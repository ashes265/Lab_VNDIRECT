package edu.java.spring.controller;

import edu.java.spring.model.Student;
import edu.java.spring.model.University;
import edu.java.spring.model.ClassP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {
    @Autowired
    private University university;
//    @Autowired
//    @Qualifier("stu")
    private Student student;

    @Autowired
    @Qualifier("class2")
    private ClassP classStu;

//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView sayHello() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index");
//        mv.addObject("message", "Hello Spring");
//        return mv;
//    }

    @RequestMapping(value = "/printMessage", method = RequestMethod.GET)
    public ModelAndView printMessage(@RequestParam(value = "message") String message) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("printMessage");
        mv.addObject("message", message);
        return mv;
    }

    @RequestMapping(value = "/printUniversity", method = RequestMethod.GET)
    public ModelAndView printUni() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("printUniversity");
        mv.addObject("university", university);
        mv.addObject("stu", student);
        return mv;
    }

    @RequestMapping(value = "/printClass",method = RequestMethod.GET)
    public ModelAndView printClass() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("printClass");
        mv.addObject("message", "Hello Class");
//        classStu.getStudents().add(new Student(2,"Hai", new University("Havard","US")));
//        classStu.getStudents().add(new Student(3,"Hung", new University("Jdk","UK")));

        mv.addObject("classInfo", classStu);
        return mv;
    }

}
