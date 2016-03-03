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
@Transactional
public interface ProxyMealRepository extends JpaRepository<Meal, Integer> {

    @Override
    @Transactional
    Meal save (Meal meal);

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id = ?1")
    int delete(int id);

    @Override
    Meal findOne(Integer id);

    @Override
    List<Meal> findAll();
}
