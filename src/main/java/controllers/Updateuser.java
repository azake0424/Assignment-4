package controllers;

import interfaces.IUserRepository;
import models.Users;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Updateuser")
public class Updateuser extends HttpServlet {
    private final IUserRepository userRepository = new UserRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = new Users(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("username"),
                request.getParameter("password")
        );
        userRepository.update(users);
        response.sendRedirect(request.getContextPath() + "/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
