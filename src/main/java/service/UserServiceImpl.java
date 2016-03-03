package service;

import javassist.NotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
