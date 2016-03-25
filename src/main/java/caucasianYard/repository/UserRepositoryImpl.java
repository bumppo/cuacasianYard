package caucasianYard.repository;

import caucasianYard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Sort SORT_BY_NAME = new Sort("name");

    @Autowired
    private ProxyUserRepository proxy;

    @Override
    public List<User> getAll() {
        return proxy.findAll(SORT_BY_NAME);
    }

    @Override
    public User get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public User getWithMeals(int id) {
        return proxy.getWithMeals(id);
    }

    @Override
    public User save(User user) {
        return proxy.save(user);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }
}
