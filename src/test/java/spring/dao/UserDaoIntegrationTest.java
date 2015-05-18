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
import spring.model.User;

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
    public void testById(){
        User user = userDao.findUserById(1);
        Assert.assertEquals("allyn",user.getUsername());
        Assert.assertEquals(1,user.getId());
    }

    @Test
    public void tesFindByUsernamePassword(){
        User user = userDao.findUserByUsernameAndPassword("allyn","password");
        Assert.assertNotNull(user);
    }

    
}
