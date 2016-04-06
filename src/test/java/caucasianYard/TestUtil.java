package caucasianYard;

import caucasianYard.matcher.ModelMatcher;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

/**
 * Created by VMoskalik on 06.04.2016.
 */
public class TestUtil {
    public static ResultActions print(ResultActions action) throws UnsupportedEncodingException {
        System.out.println(getContent(action));
        return action;
    }

    public static String getContent(ResultActions action) throws UnsupportedEncodingException {
        return action.andReturn().getResponse().getContentAsString();
    }

    /**
     * Compare entities using toString
     */
    public static class ToStringModelMatcher<T> extends ModelMatcher<T, String> {
        public ToStringModelMatcher(Class<T> entityClass) {
            super(Object::toString, entityClass);
        }
    }
}
