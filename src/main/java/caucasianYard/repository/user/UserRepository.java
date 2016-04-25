package caucasianYard.repository.user;

import caucasianYard.model.User;

import java.util.List;

/**
 * Created by VMoskalik on 02.03.2016.
 */

public interface UserRepository {

    List<User> getAll();

    //null if not found
    User get(int id);

    User getWithMeals(int id);

    User save(User user);

    //false if not found
    boolean delete(int id);
}
