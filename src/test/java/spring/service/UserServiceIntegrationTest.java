package spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import spring.configuration.AppConfig;
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
}
