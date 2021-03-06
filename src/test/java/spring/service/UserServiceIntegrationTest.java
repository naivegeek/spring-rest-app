package spring.service;

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
 * Created by srinathmedala on 5/17/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUsers() {
        List<User> users = userService.findAllUsers();
        org.junit.Assert.assertTrue(users != null && users.size() > 0);
    }

    @Test
    public void testLoginSuccess() {
        AuthDTO auth = new AuthDTO();
        auth.setUsername("allyn");
        auth.setPassword("password");
        User user = userService.findUserByUsernameAndPassword(auth.getUsername(), auth.getPassword());
        org.junit.Assert.assertTrue(user != null && user.getUsername().equals("allyn"));

    }

    @Test
    public void testAllUsers() {
        List<User> users = userService.findAllUsers();
        Assert.assertTrue(users != null && users.size() >= 4);
    }

    @Test
    public void testUserByCity() {
        List<User> users = userService.findUsersByCityName("NewYork");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userService.findUsersByCityName("culvercity");
        Assert.assertTrue(users != null && users.size() > 0);


        users = userService.findUsersByCityName("westwood");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userService.findUsersByCityName("silverlake");
        Assert.assertTrue(users != null && users.size() == 0);
    }

    @Test
    public void testUserByCompany() {

        List<User> users = userService.findUsersByCompanyName("MGO");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userService.findUsersByCompanyName("Hulu");
        Assert.assertTrue(users != null && users.size() > 0);

        users = userService.findUsersByCompanyName("Netflix");
        Assert.assertTrue(users != null && users.size() > 0);

        /* Failure Case*/
        users = userService.findUsersByCompanyName("Amazon");
        Assert.assertTrue(users != null && users.size() == 0);
    }


    @Test
    public void testDbUp() {
        int result = userService.isDbAlive();
        Assert.assertTrue(result == 1);
    }

}
