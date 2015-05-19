package spring.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import spring.configuration.AppConfig;
import spring.dto.AuthDTO;
import spring.model.User;

import java.util.List;

/**
 * Created by srinathmedala on 5/18/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class UserDaoIntegrationTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testById() {
        User user = userDao.findUserById(1);
        Assert.assertEquals("allyn", user.getUsername());
        Assert.assertEquals(1, user.getId());
    }

    @Test
    public void testFindByUsernamePassword() {
        User user = userDao.findUserByUsernameAndPassword("allyn", "password");
        Assert.assertNotNull(user);

    }

    @Test
    public void testUsers() {
        List<User> users = userDao.findAllUsers();
        org.junit.Assert.assertTrue(users != null && users.size() > 0);
    }

    @Test
    public void testLoginSuccess() {
        AuthDTO auth = new AuthDTO();
        auth.setUsername("allyn");
        auth.setPassword("password");
        User user = userDao.findUserByUsernameAndPassword(auth.getUsername(), auth.getPassword());
        org.junit.Assert.assertTrue(user != null && user.getUsername().equals("allyn"));

    }

    @Test
    public void testAllUsers() {
        List<User> users = userDao.findAllUsers();
        Assert.assertTrue(users != null && users.size() >= 4);
    }

    @Test
    public void testUserByCity() {
        List<User> users = userDao.findUsersByCityName("NewYork");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userDao.findUsersByCityName("culvercity");
        Assert.assertTrue(users != null && users.size() > 0);


        users = userDao.findUsersByCityName("westwood");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userDao.findUsersByCityName("silverlake");
        Assert.assertTrue(users != null && users.size() == 0);
    }

    @Test
    public void testUserByCompany() {

        List<User> users = userDao.findUsersByCompanyName("MGO");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userDao.findUsersByCompanyName("Hulu");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userDao.findUsersByCompanyName("Netflix");
        Assert.assertTrue(users != null && users.size() > 0);

        /* Failure Case*/
        users = userDao.findUsersByCompanyName("Amazon");
        Assert.assertTrue(users != null && users.size() == 0);
    }


    @Test
    public void testDbUp() {
        int result = userDao.isDbAlive();
        Assert.assertTrue(result == 1);
    }


}
