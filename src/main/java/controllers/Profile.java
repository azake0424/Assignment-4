package controllers;

import interfaces.IUserService;
import models.Users;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Stack;

@WebServlet(name = "Profile")
public class Profile extends HttpServlet {
    private final IUserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            session.setAttribute("username",username);
            request.setAttribute("username",username);
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else if (session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
