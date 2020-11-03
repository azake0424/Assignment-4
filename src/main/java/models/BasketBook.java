package models;

import java.util.ArrayList;
import java.util.List;

public class BasketBook {
    private List<Book> bookList;

    public BasketBook(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BasketBook() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
