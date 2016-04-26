package caucasianYard.service;

import caucasianYard.model.Meal;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */

public interface MealService {

    List<Meal> getAll();

    Meal get (int id) throws NotFoundException;

    Meal save(Meal meal);

    void update (Meal meal);

    void delete(int id) throws NotFoundException;
}
