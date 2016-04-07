package caucasianYard.service;

import caucasianYard.model.Meal;
import caucasianYard.util.exception.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static caucasianYard.MealTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-app.xml"
})
public class MealServiceTest extends AbstractServiceTest {

    @Autowired
    private MealService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        MEAL_MATCHER.assertCollectionEquals(MEALS, service.getAll());
    }

    @Test
    public void testGet() throws Exception {
        Meal actual = service.get(MEAL1_ID);
        MEAL_MATCHER.assertEquals(MEAL1, actual);
    }

    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(0);
    }

    @Test
    public void testSave() throws Exception {
        Meal created = getCreated();
        service.save(created);
        MEAL_MATCHER.assertCollectionEquals(Arrays.asList(MEAL1, MEAL2, MEAL3, MEAL4, MEAL5, MEAL6, created), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        // the same method as testSave
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(MEAL1_ID);
        MEAL_MATCHER.assertCollectionEquals(Arrays.asList(MEAL2, MEAL3, MEAL4, MEAL5, MEAL6), service.getAll());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(0);
    }
}
