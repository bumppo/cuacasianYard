package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getWithMeals(int id) {
        return repository.getWithMeals(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
