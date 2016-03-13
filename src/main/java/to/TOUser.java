package to;

import model.User;

/**
 * Created by forza on 13.03.2016.
 */
public class TOUser extends TOBaseEntity {

    protected String name;

    public TOUser() {
    }

    public TOUser(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
