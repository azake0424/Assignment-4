package repository;

import interfaces.IBasketRepository;
import interfaces.IDBRepository;
import models.Basket;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BasketRepository implements IBasketRepository {
    private final IDBRepository dbrepo = new PostgresRepository();
    @Override
    public List<Basket> getMyBasket(String username) {
        return query("SELECT * FROM books WHERE username = '"+ username +"';");
    }

    @Override
    public void moveBackTheBook(int id, String username) {
        try {
            String sql = "DELETE from basket WHERE bookid = ? and username = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, username);
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void removeOrderSByBookID(int bookId) {
        try {
            String sql = "DELETE from basket WHERE bookid = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setInt(1, bookId);
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public Basket checkBasket(int id, String username) {
        return queryOne("SELECT * FROM basket WHERE bookid = "+ id +" AND username = '"+ username +"'");
    }

    @Override
    public void add(Basket entity) {
        try {
            String sql = "INSERT INTO basket(username, bookid) VALUES(?, ?);";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getUsername());
            stmt.setInt(2, entity.getBookId());
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void update(Basket entity) {

    }

    @Override
    public void remove(Basket entity) {

    }

    @Override
    public List<Basket> query(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Basket> baskets = new LinkedList<>();
            while (rs.next()) {
                Basket basket = new Basket(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("bookId")
                );
                baskets.add(basket);
            }
            return baskets;
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getSQLState());
        }
    }

    @Override
    public Basket queryOne(String sql) {
        return null;
    }
}
