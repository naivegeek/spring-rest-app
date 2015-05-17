package spring.dao;

import org.springframework.transaction.annotation.Transactional;
import spring.model.User;

import java.util.List;

/**
 * Created by srinathmedala on 5/16/15.
 */
public interface UserDao {

    User findUserById(int id);

    List<User> findAllUsers();

    @Transactional
    void deleteUser(int id);

    List<User> findUsersByCompanyName( String companyName);
    List<User> findUsersByCityName(String cityName);

    @Transactional
    User save (User user);

    int isDbAlive();

}
