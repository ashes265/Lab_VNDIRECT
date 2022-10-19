package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.model.Group;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/nhom")
public class GroupController {
    private final static Logger LOGGER = Logger.getLogger(GroupController.class);

    @Autowired
    private GroupDAO groupDAO;

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public ModelAndView addForm() {
        return new ModelAndView("group.form", "command", new Group());
    }

    @RequestMapping(value = "/luu", method = RequestMethod.POST)
    public ModelAndView addNew(@Valid @ModelAttribute("command") Group group, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("group.form", "command", group);
            model.addObject("errors", result);
            return model;
        }
        if (group.getId() > 0) {
            groupDAO.update(group);
            LOGGER.info("update group -----> " + group);
        } else {
            groupDAO.insert(group);
            LOGGER.info("add new group -----> " + group);
        }
        return new ModelAndView("redirect:/nhom/list");

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("group.list");
        mv.addObject("groups", groupDAO.list());
        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable(value = "id", required = false) Integer id) {
        if (id == null) {
            return new ModelAndView("redirect:/nhom/list");
        }
        groupDAO.delete(id);
        return new ModelAndView("redirect:/nhom/list");
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ModelAndView updateForm(@RequestParam(value = "id", required = true) Integer id) {
        Group group = groupDAO.get(id);
        if (group == null) {
            return new ModelAndView("redirect:/nhom/list");
        }
//        ModelAndView mv=new ModelAndView("group.form");
//        mv.addObject("group",group);
//        mv.addObject("id",group.getId());
//        return mv;
        return new ModelAndView("group.form", "command", group);
    }

    @RequestMapping(value = "/listFilter", method = RequestMethod.GET)
    public ModelAndView listFilter(@RequestParam(value = "filter", required = false) String filter) {
        ModelAndView mv = new ModelAndView("group.list");
        mv.addObject("filter",filter);
        mv.addObject("groups", groupDAO.listFilter(filter));
        return mv;
    }
}
