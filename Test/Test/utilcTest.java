package Test;

import com.sinaapp.moyun.model.po.User;
import com.sinaapp.moyun.util.Hibernate.Utilc;
import org.junit.Test;

/**
 * Created by Moy on ÎåÔÂ27  027.
 */
public class utilcTest {

    @Test
    public void testGetFiledId() throws Exception {
        User u = new User();
        u.setId(226);
        Object o = Utilc.getFiledId(u);
        System.out.println("  # --> " +o);
    }
}