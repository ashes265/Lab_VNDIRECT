package edu.hanoi.spring.controller;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAPI {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userDAO.list();
    }

    @RequestMapping(value = "/user/get/{name}", method = RequestMethod.GET)
    public User get(@PathVariable(name = "name") String name) {
        return userDAO.get(name);
    }
}
