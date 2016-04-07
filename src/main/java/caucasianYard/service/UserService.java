package caucasianYard.service;

import caucasianYard.model.User;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
public interface UserService {

    List<User> getAll();

    User get(int id) throws NotFoundException;

    User getWithMeals(int id);

    User save(User user);

    void delete(int id) throws NotFoundException;
}
