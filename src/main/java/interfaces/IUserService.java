package interfaces;

import models.UserLoginData;
import models.Users;

public interface IUserService {
        Users getUserByID(long id);

        Users getUserByUsername(String username);

        void addUser(Users users);

        void updateUser(Users users);

        Users checkUserExistence(UserLoginData userLoginData);
}
