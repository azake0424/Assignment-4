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
        Cookie cookie = new Cookie("role",userLoginData.getUsername());
        response.addCookie(cookie);


        if (checkUserExistence(userLoginData)) {
            HttpSession session = request.getSession();
            session.setAttribute("username",userLoginData.getUsername());
            response.sendRedirect(request.getContextPath() + "/main");
        }else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        public boolean checkUserExistence(UserLoginData userLoginData) {
            Users users = userService.checkUserExistence(userLoginData);
            return users != null;
    }
}
