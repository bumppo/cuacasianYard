package repository;

import model.Meal;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
public interface MealRepository {

    Meal save (Meal meal);

    //false if not found
    boolean delete(int id);

    //null if not found
    Meal get(int id);

    List<Meal> getAll();
}
