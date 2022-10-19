package edu.hanoi.spring.controller;

import edu.hanoi.spring.model.Message;
import edu.hanoi.spring.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {
//    @MessageMapping("/message")
//    @SendTo("/topic/chat")
//    public Message say(Message message){
//        System.out.println("From Client: "+message.getContent());
//        try{
//            Thread.sleep(2000);
//        }catch (Exception e){}
//        return new Message("Hanoi: "+message.getContent()+"!");
//    }

    @MessageMapping("/message")
    @SendTo("/topic/chat")
    public Message say(Message message, Principal principal) {
        return new Message(principal.getName() + ": " + message.getContent() + "!");
    }


//    @MessageMapping("/user")
//    @SendTo("/topic/chat")
//    public Message add(User user) {
//        System.out.println("user " + user.getUsername() + "- email " + user.getEmail());
//        return new Message(user.getUsername());
//    }
}
