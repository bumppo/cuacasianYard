package repository;

import model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
public interface ProxyMealRepository extends JpaRepository<Meal, Integer> {

    @Override
    List<Meal> findAll();

    @Override
    Meal findOne(Integer id);

    @Override
    Meal save (Meal meal);

    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id = ?1")
    int delete(int id);
}
