package models;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String isbn;
    private int count;
    private String img;

    public Book() {
    }

    public Book(String title, String author, String isbn, int count, String img) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.count = count;
        this.img = img;
    }

    public Book(int bookId, String title, String author, String isbn, int count, String img) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.count = count;
        this.img = img;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //public String getDescription() {
    //    return description;
    //}

    //public void setDescription(String description) {
    //    this.description = description;
    //}

    //public int getPrice() {
    //    return price;
    //}

    //public void setPrice(int price) {
    //    this.price = price;
    //}

    //public int getGraduateyear() {
    //    return graduateyear;
    //}

    //public void setGraduateyear(int graduateyear) {
    //    this.graduateyear = graduateyear;
    //}

    //public String getGenre() {
    //    return genre;
    //}

    //public void setGenre(String genre) {
    //    this.genre = genre;
    //}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "book{" +
                "id='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", count='" + count + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
