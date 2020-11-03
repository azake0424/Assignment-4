package controllers;

import interfaces.IBookRepository;
import models.Book;
import repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Main")
public class Main extends HttpServlet {
    private final IBookRepository bookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        session.setAttribute("username",username);
        request.setAttribute("books",bookRepository.getAllBooks());
        request.setAttribute("error",request.getAttribute("error"));
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
