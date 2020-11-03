package controllers;

import interfaces.IBookRepository;
import models.Book;
import repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "Admin")
public class Admin extends HttpServlet {
    private final IBookRepository bookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("librarian",username);
        if (username.equals("librarian")&&password.equals("librarian")){
            response.sendRedirect(request.getContextPath()+"/admin");
        }else {
            request.getRequestDispatcher("/log.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("librarian").equals("librarian")) {
            request.setAttribute("books", bookRepository.getAllBooks());
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        else if (session.getAttribute("librarian").equals(null)){
            request.getRequestDispatcher("/log.jsp").forward(request,response);
        }
    }
}
