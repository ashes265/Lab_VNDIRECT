package edu.java.spring.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students2")
public class TestController {
//    @GetMapping("new")
    public String newForm(){
        return "students2/addOrEdit";
    }

//    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(){
        return "students2/detail";
    }

}
