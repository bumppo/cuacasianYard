package caucasianYard.service;

import caucasianYard.model.MenuMeal;
import caucasianYard.repository.menuMeal.MenuMealRepository;
import caucasianYard.util.exception.ExceptionUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by VMoskalik on 26.04.2016.
 */

@Service
@Transactional(readOnly = true)
public class MenuMealServiceImpl implements MenuMealService {

    @Autowired
    MenuMealRepository repository;

    @Override
    public List<MenuMeal> getAll() {
        return repository.getAll();
    }

    @Override
    public MenuMeal get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    @Transactional
    public MenuMeal save(MenuMeal menuMeal) {
        return repository.save(menuMeal);
    }

    @Override
    @Transactional
    public void update(MenuMeal menuMeal) {
        repository.save(menuMeal);
    }

    @Override
    @Transactional
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }
}
