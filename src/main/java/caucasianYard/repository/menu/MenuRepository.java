package caucasianYard.repository.menu;

import caucasianYard.model.Menu;

import java.util.List;

/**
 * Created by VMoskalik on 25.04.2016.
 */
public interface MenuRepository {

    List<Menu> getAll();

    Menu get(int id);

    Menu getWithMenuMeals(int id);
}
