package controllers;

import interfaces.IBookRepository;
import interfaces.IBookService;
import models.Book;
import repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Update")
public class Update extends HttpServlet {
    private final IBookRepository bookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book(
                request.getParameter("title"),
                request.getParameter("author"),
                request.getParameter("isbn"),
                Integer.parseInt(request.getParameter("count")),
                request.getParameter("image")
        );
        bookRepository.update(book);
        response.sendRedirect(request.getContextPath()+"/edit");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookRepository.getBookByID(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
