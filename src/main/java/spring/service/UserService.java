package spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.model.User;

import java.util.List;

/**
 * Created by srinathmedala on 5/16/15.
 */

public interface UserService {

    User findUserById(int id);
    List<User> findAllUsers();
    List<User> findUsersByCompanyName( String companyName);
    List<User> findUsersByCityName(String cityName);
    void deleteUser(int id);
    User save (User user);
    int isDbAlive();

}
