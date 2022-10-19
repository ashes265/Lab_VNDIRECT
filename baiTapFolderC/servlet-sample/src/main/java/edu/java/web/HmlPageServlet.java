package edu.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/html",name = "html-servlet")
//@ServletSecurity(
//        @HttpConstraint(
//                transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL,
//                rolesAllowed = {"read"}
//        )
//)
public class HmlPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<html><head><title>Welcome to our website!</title></head>");
        resp.getWriter().println("<body>\n" +
                "    <table border=\"1\">\n" +
                "        <tr>\n" +
                "            <td>#</td>\n" +
                "            <td>Name</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>1</td>\n" +
                "            <td>Nguyen Van A</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>2</td>\n" +
                "            <td>Tran Thi B</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>3</td>\n" +
                "            <td>Le Van C</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
