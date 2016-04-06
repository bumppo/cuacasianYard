package caucasianYard;

import caucasianYard.matcher.ModelMatcher;
import caucasianYard.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by VMoskalik on 06.04.2016.
 */
public class UserTestData {

    public static final ModelMatcher<User, String> MATCHER = new TestUtil.ToStringModelMatcher<>(User.class);

    public static final int START_SEQ = 100;
    public static final int USER1_ID = START_SEQ;


    public static final User USER1 = new User(USER1_ID, "Виталик");
    public static final User USER2 = new User(USER1_ID + 1, "Алексей Аксенов");
    public static final User USER3 = new User(USER1_ID + 2, "Алексей Хныкин");
    public static final User USER4 = new User(USER1_ID + 3, "Диана");
    public static final User USER5 = new User(USER1_ID + 4, "Шамиль");
    public static final User USER6 = new User(USER1_ID + 5, "Макс");

    //sorted by name
    public static final List<User> USERS = Arrays.asList(USER2, USER3, USER1, USER4, USER6, USER5);

}
