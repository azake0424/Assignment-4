package controllers;

import models.UserLoginData;
import models.Users;
import interfaces.IUserService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    private final IUserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserLoginData userLoginData = new UserLoginData(request.getParameter("username"), request.getParameter("password"));
        if (checkUserExistence(userLoginData)) {
            Cookie cookie = new Cookie("username", userLoginData.getUsername());
            response.addCookie(cookie);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

        response.sendRedirect(request.getContextPath() + "/main");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public boolean checkUserExistence(UserLoginData userLoginData) {
        Users users = userService.checkUserExistence(userLoginData);
        return users != null;
    }
}
