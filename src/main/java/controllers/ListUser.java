package controllers;

import interfaces.IUserRepository;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ListUser")
public class ListUser extends HttpServlet {
    private final IUserRepository userRepository = new UserRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("librarian").equals("librarian")) {
            request.setAttribute("users", userRepository.getAllUsers());
            request.getRequestDispatcher("/listusers.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/log.jsp").forward(request,response);
        }
    }
}
