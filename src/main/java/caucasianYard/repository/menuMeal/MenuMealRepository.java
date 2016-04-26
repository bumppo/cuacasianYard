package caucasianYard.repository.menuMeal;

import caucasianYard.model.MenuMeal;

import java.util.List;

/**
 * Created by VMoskalik on 26.04.2016.
 */

public interface MenuMealRepository {

    List<MenuMeal> getAll();

    //null if not found
    MenuMeal get(int id);

    MenuMeal save(MenuMeal menuMeal);

    //false if not found
    boolean delete(int id);
}
