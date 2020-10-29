package interfaces;

import models.UserLoginData;
import models.Users;


public interface IUserRepository extends IEntityRepository<Users> {
    Users getUserByID(long userId);

    Users findUserByLogin(UserLoginData data);

    Users getUserByUsername(String username);
}