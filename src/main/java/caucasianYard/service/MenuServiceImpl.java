package caucasianYard.service;

import caucasianYard.model.Menu;
import caucasianYard.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by VMoskalik on 25.04.2016.
 */

@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> getAll() {
        return repository.getAll();
    }

    @Override
    public Menu get(int id) {
        return repository.get(id);
    }

    @Override
    public Menu getWithMenuMeals(int id) {
        return repository.getWithMenuMeals(id);
    }
}
