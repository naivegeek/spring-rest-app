package spring.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.AbstractDao;
import spring.dao.UserDao;
import spring.model.User;

/**
 * Created by srinath medala on 5/16/15.
 */

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public User findUserById(int id) {

        @SuppressWarnings("unchecked")
        List<User> users = getSession().createQuery("from User u  where u.id = :id ").setParameter("id", id).list();
        User u = null;
        if (users != null && !users.isEmpty()) {
            u = users.get(0);
        }
        return u;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        List<User> users = getSession().createQuery("from User u ").list();
        return users;
    }

    @Override
    public void deleteUser(User user) {
        delete(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findUsersByCompanyName(String companyName) {
        List<User> users = getSession().createQuery("from User u  where u.companyName = :companyName ")
                .setParameter("companyName", companyName).list();
        return users;
    }

    @Override
    public List<User> findUsersByCityName(String cityName) {
        @SuppressWarnings("unchecked")
        List<User> users = getSession().createQuery("from User u  where u.currentCity = :cityName ")
                .setParameter("cityName", cityName).list();
        return users;

    }

    @Override
    public User save(User user) {
        return save(user);
    }

    @Override
    public int isDbAlive() {
        BigInteger count = (BigInteger) getSession().createSQLQuery("select count(*)").uniqueResult();
        if (count != null) {
            return count.intValue();
        } else {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        List<User> users = getSession()
                .createQuery("from User u  where u.username = :username and u.password = :password ")
                .setParameter("username", username).setParameter("password", password).list();
        User u = null;
        if (users != null && !users.isEmpty()) {
            u = users.get(0);
        }
        return u;
    }
}
