package edu.hanoi.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Controller
public class HomeController {
    private static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "Hello Java Clazz");
        logger.info("Da truy cap vao day");
//        System.out.println("Da truy cap vao day");
        return mv;
    }

    @RequestMapping("/login")
    ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView("login");
        if (error != null) {
            mv.addObject("error", "Wrong username or password");
        }
        return mv;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping("/nguoi-dung")
    ModelAndView forUser() {
        ModelAndView mv = new ModelAndView("index");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("message", "Hello User " + auth.getName());
        return mv;
    }
}
