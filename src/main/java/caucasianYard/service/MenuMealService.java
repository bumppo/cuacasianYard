package caucasianYard.service;

import caucasianYard.model.MenuMeal;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by VMoskalik on 26.04.2016.
 */

public interface MenuMealService {

    List<MenuMeal> getAll();

    MenuMeal get(int id) throws NotFoundException;

    MenuMeal save(MenuMeal menuMeal);

    void update(MenuMeal menuMeal);

    void delete(int id) throws NotFoundException;
}
