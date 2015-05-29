package Test;

import com.sinaapp.moyun.dao.imp.UserDaoImp;
import org.junit.Test;

/**
 * Created by Moy on ÎåÔÂ28  028.
 */
public class BaseDaoTest {

    @Test
    public void testDelete() throws Exception {
        UserDaoImp userDao = new UserDaoImp();
        userDao.delete(12);
    }
}