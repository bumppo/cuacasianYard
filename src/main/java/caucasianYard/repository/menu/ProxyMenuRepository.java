package caucasianYard.repository.menu;

import caucasianYard.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by VMoskalik on 25.04.2016.
 */

public interface ProxyMenuRepository extends JpaRepository<Menu, Integer> {

    @Override
    List<Menu> findAll();

    @Override
    Menu findOne(Integer integer);

    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.menuMeals WHERE m.id=?1")
    Menu getWithMenuMeals(int id);
}
