package caucasianYard.repository.meal;

import caucasianYard.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Repository
public class MealRepositoryImpl implements MealRepository {

    @Autowired
    private ProxyMealRepository proxy;

    @Override
    public List<Meal> getAll() {
        return proxy.findAll();
    }

    @Override
    public Meal get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public Meal save(Meal meal) {
        return proxy.save(meal);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public int getTotalSum() {
        return (int)proxy.getTotalSum();
    }
}
