package caucasianYard.service;

import caucasianYard.model.User;
import caucasianYard.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import caucasianYard.repository.UserRepository;

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
        return ExceptionUtil.check(repository.get(id), id);
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
        ExceptionUtil.check(repository.delete(id), id);
    }
}
