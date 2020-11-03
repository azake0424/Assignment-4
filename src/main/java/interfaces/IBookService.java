package interfaces;

import models.Book;

public interface IBookService {
    void addBook(Book book);
    void update(Book book);
}
