package repository;

import interfaces.IDBRepository;
import interfaces.IUserRepository;
import models.UserLoginData;
import models.Users;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private IDBRepository dbrepo = new PostgresRepository();

    @Override
    public void add(Users entity) {
        try {
            String sql = "INSERT INTO users(name, email, username, password) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getEmail());
            stmt.setString(3, entity.getUsername());
            stmt.setString(4, entity.getPassword());

            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void update(Users entity) {
        String sql = "UPDATE users SET name = ?, email = ?, username = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbrepo.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getUsername());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run sql statement : " + ex.getSQLState());
        }
    }

    @Override
    public void remove(Users entity) {

    }


    @Override
    public List<Users> query(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            LinkedList<Users> users = new LinkedList<>();
            while (rs.next()) {
                Users user = new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("username")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getSQLState());
        }
    }

    @Override
    public Users queryOne(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("username")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return query("SELECT * FROM users WHERE role IS NULL");
    }

    public Users getUserByID(long id) {
        String sql = "SELECT * FROM users WHERE userid = " + id + " LIMIT 1";
        return queryOne(sql);
    }

    public Users findUserByLogin(UserLoginData data) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, data.getUsername());
            stmt.setString(2, data.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    public Users getUserByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void getRoleUser(Users entity) {
        String sql = "SELECT role FROM users WHERE name = '" + entity.getName() + "'";
        try {
            PreparedStatement preparedStatement = dbrepo.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run sql statement : " + ex.getSQLState());
        }
    }

}