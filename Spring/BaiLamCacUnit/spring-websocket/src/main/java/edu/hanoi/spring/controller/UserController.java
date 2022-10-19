package edu.hanoi.spring.controller;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.spring.model.Message;
import edu.hanoi.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;


    @MessageMapping("/user")
    @SendTo("/topic/chat")
    public Message add(User user,Message username) {
        if(username.getContent()==null){
            String status = userDAO.insert(user);
            return new Message("Save " + status + " successfull!");
        }else{
            userDAO.update(user);
            return new Message("Update successfull");
        }
    }

    //cach1
//    @MessageMapping("/user/delete")
//    @SendTo("/topic/chat")
//    public Message deleteUser(Message username) {
//        userDAO.delete(username.getContent());
//        return new Message("Delete successfull!");
//    }

    @MessageMapping("/user/delete/{username}")
    @SendTo("/topic/chat")
    public Message deleteUser(@DestinationVariable(value = "username") String username, Message mess) {
        userDAO.delete(username);
        return new Message("Delete successfull!");
    }


}
