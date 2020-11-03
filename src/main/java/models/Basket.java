package models;

public class Basket {
    public int id;
    public String username;
    public int bookId;

    public Basket(int id, String username, int bookId){
        this.id = id;
        this.username = username;
        this.bookId = bookId;
    }

    public Basket(String username, int bookId){
        this.username = username;
        this.bookId = bookId;
    }

    public Basket(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
