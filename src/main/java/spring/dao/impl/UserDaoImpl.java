package spring.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.AbstractDao;
import spring.dao.UserDao;
import spring.model.User;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by srinathmedala on 5/16/15.
 */

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public User findUserById(int id) {

        List<User> users = getSession().createQuery("from User u  where u.id = :id ").setParameter("id",id).list();
        User u = null;
        if(users!=null){
           u = users.get(0);
        }
        return u;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = getSession().createQuery("from User u ").list();
        return users;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public List<User> findUsersByCompanyName(String companyName) {
        List<User> users = getSession().createQuery("from User u  where u.companyName = :companyName ").setParameter("companyName",companyName).list();
        return users;
    }

    public List<User> findUsersByCityName(String cityName) {
        List<User> users = getSession().createQuery("from User u  where u.currentCity = :cityName ").setParameter("cityName",cityName).list();
        return users;
    }

    @Override
    public User save(User user) {
        return save(user);
    }

    public int isDbAlive() {
        BigInteger count = (BigInteger) getSession().createSQLQuery("select count(*)").uniqueResult();
        if(count!=null){
            return count.intValue();
        }else{
            return 0;
        }
    }


}
