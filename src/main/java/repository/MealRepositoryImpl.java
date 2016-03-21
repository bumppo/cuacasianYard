package repository;

import model.Meal;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.Comparator;
import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
@Repository
public class MealRepositoryImpl implements MealRepository {

    @Autowired
    ProxyMealRepository proxy;

    @Override
    public List<Meal> getAll() {
        List<Meal> list = proxy.findAll();
//        Comparator<Meal> comparator = (m, o) -> m.getUser().getName().compareTo(o.getUser().getName());
//        list.sort(comparator);
        return list;
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
}
