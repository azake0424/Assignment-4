package controllers;

import interfaces.IBasketRepository;
import interfaces.IBookRepository;
import repository.BasketRepository;
import repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteFromBasket")
public class DeleteFromBasket extends HttpServlet {
    private final IBasketRepository basketRepository = new BasketRepository();
    private final IBookRepository bookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            int bookid = Integer.parseInt(request.getParameter("bookid"));
            String username = (String) request.getParameter("username");
            basketRepository.moveBackTheBook(bookid,username);
            bookRepository.removeReader(bookid);
            request.setAttribute("my",bookRepository.getMyBooks(username));
            request.getRequestDispatcher("/basket.jsp").forward(request, response);
        } else if (session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
