package edu.hanoi.spring.controller;

import edu.hanoi.service.dao.GroupDAO;
import edu.hanoi.spring.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupDAO groupDAO;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public List<Group> list() {
        return groupDAO.list();
    }

    @RequestMapping(value = "/groups/{groupId}", method = RequestMethod.GET)
    public Group getGroup(@PathVariable(value = "groupId", required = false) int groupId) {
        return groupDAO.list().get(groupId);
    }


}
