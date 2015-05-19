package spring.service;

import java.util.List;

import spring.model.User;

/**
 * Created by srinathmedala on 5/16/15.
 */

public interface UserService {

    User findUserById(int id);

    List<User> findAllUsers();

    List<User> findUsersByCompanyName(String companyName);

    List<User> findUsersByCityName(String cityName);

    void deleteUser(User user);

    User save(User user);

    int isDbAlive();

    User findUserByUsernameAndPassword(String username, String password);

}
