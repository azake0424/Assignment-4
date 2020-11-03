package controllers;

import interfaces.IBookService;
import models.Book;
import models.Users;
import services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBook")
public class AddBook extends HttpServlet {
    private final IBookService bookService = new BookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setIsbn(request.getParameter("isbn"));
        book.setCount(Integer.parseInt(request.getParameter("count")));
        book.setImg(request.getParameter("img"));
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath()+"/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
