package repository;

import model.User;

import java.util.List;

/**
 * Created by VMoskalik on 02.03.2016.
 */
public interface UserRepository {

    User save(User user);

    //false if not found
    boolean delete(int id);

    //null if not founf
    User get(int id);

    List<User> getAll();
}
