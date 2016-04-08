package caucasianYard.service;

import caucasianYard.model.User;
import caucasianYard.util.exception.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static caucasianYard.UserTestData.*;
import static caucasianYard.MealTestData.USER1_MEALS;
import static caucasianYard.MealTestData.MEAL_MATCHER;


@ContextConfiguration({
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-app.xml"
})
public class UserServiceTest  extends AbstractServiceTest{

    @Autowired
    private UserService service;

    @Autowired
    private MealService mealService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        USER_MATCHER.assertCollectionEquals(USERS, service.getAll());
    }

    @Test
    public void testGet() throws Exception {
        User actual = service.get(USER1_ID);
        USER_MATCHER.assertEquals(USER1, actual);
    }

    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(0);
    }

    @Test
    public void testGetWithMeals() throws Exception {
        User user = service.getWithMeals(USER1_ID);
        USER_MATCHER.assertEquals(USER1, user);
        MEAL_MATCHER.assertCollectionEquals(USER1_MEALS, user.getMeals());
    }

    @Test
    public void testSave() throws Exception {
        User created = getCreated();
        service.save(created);
        USER_MATCHER.assertCollectionEquals(Arrays.asList(USER2, USER3, USER1, USER4, USER6, created, USER5), service.getAll());
    }

    @Test
    public void testSaveDuplicate() throws Exception {
        thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
        service.save(getDuplicate());
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(USER1_ID);
        USER_MATCHER.assertCollectionEquals(Arrays.asList(USER2, USER3, USER4, USER6, USER5), service.getAll());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(0);
    }
}
