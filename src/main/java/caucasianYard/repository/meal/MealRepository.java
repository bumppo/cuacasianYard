package caucasianYard.repository.meal;

import caucasianYard.model.Meal;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */

public interface MealRepository {

    List<Meal> getAll();

    //null if not found
    Meal get(int id);

    Meal save (Meal meal);

    //false if not found
    boolean delete(int id);

    int getTotalSum();
}
