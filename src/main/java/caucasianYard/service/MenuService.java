package caucasianYard.service;

import caucasianYard.model.Menu;

import java.util.List;

/**
 * Created by VMoskalik on 25.04.2016.
 */

public interface MenuService {

    List<Menu> getAll();

    Menu get(int id);

    Menu getWithMenuMeals(int id);

}
