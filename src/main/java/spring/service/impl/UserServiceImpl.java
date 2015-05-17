package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.model.User;
import spring.service.UserService;

import java.util.List;

/**
 * Created by srinathmedala on 5/16/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public List<User> findUsersByCompanyName(String companyName) {
        return userDao.findUsersByCompanyName(companyName);
    }

    public List<User> findUsersByCityName(String cityName) {
        return userDao.findUsersByCityName(cityName);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    public int isDbAlive() {
        return userDao.isDbAlive();
    }
}
