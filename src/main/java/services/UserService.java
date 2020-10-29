package services;

import interfaces.IUserRepository;
import models.UserLoginData;
import models.Users;
import repository.UserRepository;


public class UserService implements IUserService{
    private IUserRepository userrepo = new UserRepository();

    @Override
    public Users getUserByID(long id) {
        return userrepo.getUserByID(id);
    }

    @Override
    public Users getUserByUsername(String username) {
        return userrepo.getUserByUsername(username);
    }

    @Override
    public void addUser(Users users) {
        userrepo.add(users);
    }

    @Override
    public void updateUser(Users users) {
        userrepo.update(users);
    }

    @Override
    public Users checkUserExistence(UserLoginData userLoginData) {
        return userrepo.findUserByLogin(userLoginData);
    }
}
