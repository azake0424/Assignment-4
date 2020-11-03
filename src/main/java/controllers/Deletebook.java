package controllers;

import interfaces.IBookRepository;
import repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Deletebook")
public class Deletebook extends HttpServlet {
    private final IBookRepository bookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("librarian") != null){
            bookRepository.removeBook(request.getParameter("title"));
            request.setAttribute("books",bookRepository.getAllBooks());
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }
}
