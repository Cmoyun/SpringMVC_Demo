

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Moy on ÎåÔÂ24  024.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
public class UserControlTest extends AbstractJUnit4SpringContextTests {

//    @Qualifier("userService")
//    @Autowired
//    private UserService userService;


    @Before
    public void setup() {
    }

    @Test
    public void testFindAll() throws Exception {
//        userService.findAll();
    }
}