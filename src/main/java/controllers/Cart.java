package controllers;

import interfaces.IBasketRepository;
import interfaces.IBookRepository;
import models.Basket;
import models.BasketBook;
import models.Book;
import repository.BasketRepository;
import repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Cart")
public class Cart extends HttpServlet {
    private final IBookRepository bookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
           String username =(String) session.getAttribute("username");
            session.setAttribute("username",username);
            request.setAttribute("my",bookRepository.getMyBooks(username));
           request.getRequestDispatcher("/basket.jsp").forward(request, response);
        } else if (session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }else{
            PrintWriter printWriter = response.getWriter();
            response.setContentType("text/html");
            printWriter.print("No basket items<br>");
        }
    }
}
