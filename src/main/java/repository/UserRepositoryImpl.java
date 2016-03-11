package repository;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public User save(User user) {
        return proxy.save(user);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return proxy.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return proxy.findAll(SORT_BY_NAME);
    }
}
