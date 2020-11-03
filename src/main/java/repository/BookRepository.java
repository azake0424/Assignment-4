package repository;

import interfaces.IBookRepository;
import interfaces.IDBRepository;
import models.Book;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private IDBRepository dbrepo = new PostgresRepository();



    public List<Book> getAllBooks() {
        return query("SELECT * FROM books");
    }

    public  List<Book> getAllBySearch(String search) {
        String sql = "SELECT * FROM books WHERE lower(title) like lower('" + search + "%')";
        return query(sql);
    }

    @Override
    public void removeBook(String title) {
        String sql = "DELETE FROM books WHERE title = '"+ title +"'";
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            throw new BadRequestException("Cannot run SQL statement: " + e.getSQLState());

        }
    }

    @Override
    public void addReader(int bookId) {
        String sql = "UPDATE books SET count = count - 1 WHERE bookid =" + bookId + "";
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            throw new BadRequestException("Cannot run SQL statement: " + e.getSQLState());

        }
    }

    @Override
    public void removeReader(int bookId) {
        String sql = "UPDATE books SET count = count + 1 WHERE bookid =" + bookId +";";
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            throw new BadRequestException("Cannot run SQL statement: " + e.getSQLState());

        }
    }

    @Override
    public List<Book> getMyBooks(String name) {
        return query("SELECT * FROM books INNER JOIN basket on books.bookid = basket.bookid WHERE basket.username = '"+ name +"'");
    }


    public Book getBookByID(int bookid) {
        return queryOne("SELECT * FROM books WHERE bookid=" + bookid + " LIMIT 1");
    }

    public Book getBookByTitle(String title) {
        try {
            String sql = "SELECT * FROM books WHERE title like '"+ title +"%'";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            //stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getInt("bookId"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getInt("count"),
                        rs.getString("img")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void add(Book entity) {
        try {
            String sql = "INSERT INTO books(title, author, isbn, count) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getTitle());
            stmt.setString(2, entity.getAuthor());
            stmt.setString(3,entity.getIsbn());
            stmt.setInt(4,entity.getCount());
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void update(Book entity) {
        String sql = "UPDATE books SET title = ?, author = ?, img = ?, count = ? WHERE isbn=?";
        try {
            PreparedStatement preparedStatement = dbrepo.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getAuthor());
            preparedStatement.setString(3, entity.getImg());
            preparedStatement.setInt(4, entity.getCount());
            preparedStatement.setString(5, entity.getIsbn());
            preparedStatement.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run sql statement : "+ex.getSQLState());
        }
    }

    @Override
    public void remove(Book entity) {
            try {
                Statement stmt = dbrepo.getConnection().createStatement();
                stmt.execute("DELETE from books where isbn=" + entity.getIsbn());

            } catch (SQLException e) {
                throw new BadRequestException("Cannot run SQL statement: " + e.getSQLState());

            }
    }

    @Override
    public List<Book> query(String sql) {
        try {

            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            LinkedList<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("bookId"),
                        rs.getString("title"),
                        rs.getString("author"),
                        // rs.getString("description"),
                        // rs.getString("genre"),
                        // rs.getInt("price"),
                        // rs.getInt("graduateyear"),
                        rs.getString("isbn"),
                        rs.getInt("count"),
                        rs.getString("img")
                );
                books.add(book);
            }
            return books;
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getSQLState());
        }
    }

    @Override
    public Book queryOne(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new Book(
                        rs.getInt("bookId"),
                        rs.getString("title"),
                        rs.getString("author"),
                        // rs.getString("description"),
                        // rs.getString("genre"),
                        // rs.getInt("price"),
                        // rs.getInt("graduateyear"),
                        rs.getString("isbn"),
                        rs.getInt("count"),
                        rs.getString("img")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }
}
