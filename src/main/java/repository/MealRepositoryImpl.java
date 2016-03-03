package repository;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Repository
public class MealRepositoryImpl implements MealRepository {

//    private static final Sort SORT_BY_USER_NAME = new Sort("user");

    @Autowired
    ProxyMealRepository proxy;

    @Override
    public Meal save(Meal meal) {
        return proxy.save(meal);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Meal get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Meal> getAll() {
        return proxy.findAll();
    }
}
