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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AddBasket")
public class AddBasket extends HttpServlet {
    private final IBasketRepository basketRepository = new BasketRepository();
    private final IBookRepository bookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = Integer.parseInt(request.getParameter("count"));
       //Basket basket1 = basketRepository.checkBasket(Integer.parseInt(request.getParameter("bookid")),request.getParameter("username"));
        if (count == 0) {
            request.setAttribute("error","This book is not currently in our library");
            response.sendRedirect(request.getContextPath() + "/main");
        //}else if(basket1.getBookId() != 0) {
        //    response.sendRedirect(request.getContextPath() + "/main");
        } else {
            Basket basket = new Basket();
            basket.setUsername(request.getParameter("username"));
            basket.setBookId(Integer.parseInt(request.getParameter("bookid")));
            basketRepository.add(basket);
            bookRepository.addReader(Integer.parseInt(request.getParameter("bookid")));
            response.sendRedirect(request.getContextPath() + "/main");
        }
    }
}
