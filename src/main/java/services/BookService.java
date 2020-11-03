package services;

import interfaces.IBookRepository;
import interfaces.IBookService;
import models.Book;
import repository.BookRepository;

public class BookService implements IBookService{
private IBookRepository bookrepo = new BookRepository();

    @Override
    public void addBook(Book book) {

        bookrepo.add(book);

    }

    @Override
    public void update(Book book) {
        bookrepo.update(book);
    }

}
