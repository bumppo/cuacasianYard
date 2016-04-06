package caucasianYard.service;

import caucasianYard.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static caucasianYard.UserTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-app.xml"
})
public class UserServiceTest  extends AbstractServiceTest{

    @Autowired
    private UserService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        User actual = service.get(USER1_ID);
        MATCHER.assertEquals(USER1, actual);
    }

    @Test
    public void testGetWithMeals() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}
