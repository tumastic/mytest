import cn.itcast.SysUser;
import cn.itcast.dao.sysUserDao;
import cn.itcast.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextForSSM.xml")

public class userServiceTest {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private sysUserDao sysUserDao;
    @Test
    public void loadUserByUsernameTest(){
       SysUser user = sysUserDao.findUserByName("test");
        //UserDetails test = userService.loadUserByUsername("test");
        System.out.println(user);
    }
}
