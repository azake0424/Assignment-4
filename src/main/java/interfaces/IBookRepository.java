package interfaces;

import controllers.ListUser;
import models.Book;

import java.util.List;

public interface IBookRepository extends IEntityRepository<Book>{

    List<Book> getAllBooks();

    Book getBookByID(int bookid);

    Book getBookByTitle(String title);

    List<Book> getAllBySearch(String search);

    void removeBook(String title);

    void addReader(int bookId);

    void removeReader(int bookId);

    List<Book> getMyBooks(String name);

}