package edu.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/j_security_check")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String username=req.getParameter("j_username");
            String password=req.getParameter("j_password");
            req.login(username,password);
            req.getRequestDispatcher("/html").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("Failed to login");
        }
    }
}
