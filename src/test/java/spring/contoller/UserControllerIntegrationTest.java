package spring.contoller;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import spring.configuration.AppConfig;
import spring.controller.UserController;
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
public class UserControllerIntegrationTest {

    @Autowired
    private UserController userController;

    @Test
    public void testLoginSuccess() {
        AuthDTO auth = new AuthDTO();
        auth.setUsername("allyn");
        auth.setPassword("password");
        String status = userController.login(auth);
        org.junit.Assert.assertTrue(status != null && "success".equals(status));

    }

    @Test
    public void testLoginFailure() {
        AuthDTO auth = new AuthDTO();
        auth.setUsername("allyn");
        auth.setPassword("pass");
        String status = userController.login(auth);
        org.junit.Assert.assertTrue(status != null && "failure".equals(status));
    }

    @Test
    public void testAllUsers(){
       List<User> users = userController.getAllUsers();
       Assert.assertTrue(users!=null && users.size()>=4);
    }


}
