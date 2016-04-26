package caucasianYard.repository.menuMeal;

import caucasianYard.model.MenuMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by VMoskalik on 26.04.2016.
 */

public interface ProxyMenuMealRepository extends JpaRepository<MenuMeal, Integer> {

    @Override
    List<MenuMeal> findAll();

    @Override
    MenuMeal findOne(Integer id);

    @Override
    MenuMeal save(MenuMeal menuMeal);

    @Modifying
    @Query("DELETE FROM MenuMeal m WHERE m.id=?1")
    int delete(int id);
}
