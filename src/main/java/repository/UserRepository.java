package repository;

import model.User;

import java.util.List;

/**
 * Created by VMoskalik on 02.03.2016.
 */
public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();
}
