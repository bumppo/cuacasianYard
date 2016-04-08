package caucasianYard;

import caucasianYard.matcher.ModelMatcher;
import caucasianYard.model.Meal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static caucasianYard.UserTestData.*;


public class MealTestData {

    public static final ModelMatcher<Meal, String> MEAL_MATCHER = new TestUtil.ToStringModelMatcher<>(Meal.class);

    public static final int MEAL1_ID = 106;

    public static final Meal MEAL1 = new Meal(MEAL1_ID, "Долма с виноградными листьями", 350);
    public static final Meal MEAL2 = new Meal(MEAL1_ID + 1, "Рис отварной", 70);
    public static final Meal MEAL3 = new Meal(MEAL1_ID + 2, "Суп Харчо", 180);
    public static final Meal MEAL4 = new Meal(MEAL1_ID + 3, "Сок Свелл", 70);
    public static final Meal MEAL5 = new Meal(MEAL1_ID + 4, "Картофель жареный", 90);
    public static final Meal MEAL6 = new Meal(MEAL1_ID + 5, "Жаркое Кав. Дворик", 360);

    public static final List<Meal> MEALS = Arrays.asList(MEAL1, MEAL2, MEAL3, MEAL4, MEAL5, MEAL6);

    public static Meal getCreated() {
        Meal created = new Meal(null, "Новое блюдо", 14);
        created.setUser(USER1);
        return created;
    }

    public static final List<Meal> USER1_MEALS = Collections.singletonList(MEAL1);
}
