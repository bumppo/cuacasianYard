package caucasianYard.repository.menuMeal;

import caucasianYard.model.MenuMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by VMoskalik on 26.04.2016.
 */

@Repository
public class MenuMealRepositoryImpl implements MenuMealRepository {

    @Autowired
    private ProxyMenuMealRepository proxy;

    @Override
    public List<MenuMeal> getAll() {
        return proxy.findAll();
    }

    @Override
    public MenuMeal get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public MenuMeal save(MenuMeal menuMeal) {
        return proxy.save(menuMeal);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }
}
