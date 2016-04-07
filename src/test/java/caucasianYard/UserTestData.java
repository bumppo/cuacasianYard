package caucasianYard;

import caucasianYard.matcher.ModelMatcher;
import caucasianYard.model.User;

import java.util.Arrays;
import java.util.List;


public class UserTestData {

    public static final ModelMatcher<User, String> USER_MATCHER = new TestUtil.ToStringModelMatcher<>(User.class);

    public static final int START_SEQ = 100;

    public static final int USER1_ID = START_SEQ;

    public static final User USER1 = new User(START_SEQ, "Виталик");
    public static final User USER2 = new User(START_SEQ + 1, "Алексей Аксенов");
    public static final User USER3 = new User(START_SEQ + 2, "Алексей Хныкин");
    public static final User USER4 = new User(START_SEQ + 3, "Диана");
    public static final User USER5 = new User(START_SEQ + 4, "Шамиль");
    public static final User USER6 = new User(START_SEQ + 5, "Макс");

    //sorted by name
    public static final List<User> USERS = Arrays.asList(USER2, USER3, USER1, USER4, USER6, USER5);

    public static User getCreated(){
        return new User(null, "Новый пользователь");
    }

    public static User getDuplicate(){
        return new User(null, "Виталик");
    }
}
