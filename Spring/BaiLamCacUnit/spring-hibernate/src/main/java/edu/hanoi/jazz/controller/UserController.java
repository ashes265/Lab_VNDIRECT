package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/add")
    public ModelAndView addForm() {
        ModelAndView mv = new ModelAndView("user.form", "command", new User());
        mv.addObject("groups", toGroupMap(groupDAO.list()));
        return mv;
    }

    private Map<Integer, String> toGroupMap(List<Group> groups) {
        Map<Integer, String> map = new HashMap<>();
        groups.forEach(group -> map.put(group.getId(), group.getName()));
        return map;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView addNew(User user, BindingResult result) {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
            model = new ModelAndView("user.form", "command", new User());
            model.addObject("groups", toGroupMap(groupDAO.list()));
            model.addObject("errors", result);
            return model;
        }
        userDAO.insert(user);
        LOGGER.info("Add new user ----> " + user.getUsername() + " successfull!");
        return new ModelAndView("redirect:/user/add");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("user.list");
        mv.addObject("users", userDAO.list());
        mv.addObject("average",userDAO.avarageAge());
        return mv;
    }

    @RequestMapping(value = "/listFilter",method = RequestMethod.GET)
    public ModelAndView listFilter(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView mv = new ModelAndView("user.list");
        mv.addObject("users", userDAO.listFilter(id));
        mv.addObject("average",userDAO.avarageAge());
        return mv;
    }

    @RequestMapping("/detail/{username}")
    public ModelAndView detail(@PathVariable(value = "username", required = false)String name){
        ModelAndView mv=new ModelAndView("user.detail");
        mv.addObject("user",userDAO.get(name));
        return mv;
    }

    @RequestMapping(value = "delete/{name}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "name", required = false)String name){
        userDAO.delete(name);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/listOlder")
    public ModelAndView listOlder(){
        ModelAndView mv = new ModelAndView("user.list");
        mv.addObject("users", userDAO.listOlder());
        mv.addObject("average",userDAO.avarageAge());
        return mv;
    }

    @RequestMapping(value = "/addMany")
    public String addRandom(){
        userDAO.addBatch();
        return "redirect:/user/list";
    }
}
