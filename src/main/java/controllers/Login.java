package controllers;

import models.UserLoginData;
import models.Users;
import services.IUserService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("auth_error") != null) {
            request.setAttribute("error", "The error occured during sign in");
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    public boolean checkUserExistence(UserLoginData userLoginData) {
        Users users = userService.checkUserExistence(userLoginData);
        return users != null;
    }
}
