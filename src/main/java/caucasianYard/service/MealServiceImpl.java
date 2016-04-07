package caucasianYard.service;

import caucasianYard.model.Meal;
import caucasianYard.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import caucasianYard.repository.MealRepository;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Service
@Transactional(readOnly = true)
public class MealServiceImpl implements MealService {

    @Autowired
    MealRepository repository;

    @Override
    public List<Meal> getAll() {
        return repository.getAll();
    }

    @Override
    public Meal get(int id) {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    @Transactional
    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    @Override
    @Transactional
    public void update(Meal meal) {
        repository.save(meal);
    }

    @Override
    @Transactional
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }
}
