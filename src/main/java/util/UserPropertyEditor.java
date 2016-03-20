package util;

import model.User;

import java.beans.PropertyEditorSupport;

/**
 * Created by forza on 20.03.2016.
 */
public class UserPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        user.setId(Integer.parseInt(text));
        setValue(user);
    }
}
