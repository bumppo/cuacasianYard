package service;

import model.Meal;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
public interface MealService {

    Meal save(Meal meal);

    void update (Meal meal);

    Meal get (int id);

    void delete(int id);

    List<Meal> getAll();
}
