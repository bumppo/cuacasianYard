package service;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepository;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Service
public class MealServiceImpl implements MealService {

    @Autowired
    MealRepository repository;

    @Override
    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    @Override
    public void update(Meal meal) {
        repository.save(meal);
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Meal> getAll() {
        return null;
    }
}
