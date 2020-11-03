package interfaces;

import models.UserLoginData;
import models.Users;

import java.util.List;


public interface IUserRepository extends IEntityRepository<Users> {

    List<Users> getAllUsers();

    Users getUserByID(long userId);

    Users findUserByLogin(UserLoginData data);

    Users getUserByUsername(String username);

    void getRoleUser(Users users);
}