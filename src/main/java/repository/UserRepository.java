package repository;

import model.User;

import java.util.List;

/**
 * Created by VMoskalik on 02.03.2016.
 */
public interface UserRepository {

    List<User> getAll();

    //null if not founf
    User get(int id);

    User save(User user);

    //false if not found
    boolean delete(int id);
}
