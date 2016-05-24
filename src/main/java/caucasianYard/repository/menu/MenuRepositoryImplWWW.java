package caucasianYard.repository.menu;

import caucasianYard.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MenuRepositoryImplWWW implements MenuRepository {

    @Autowired
    private ProxyMenuRepository proxy;

    @Override
    public List<Menu> getAll() {
        return proxy.findAll();
    }

    @Override
    public Menu get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public Menu getWithMenuMeals(int id) {
        return proxy.getWithMenuMeals(id);
    }
}