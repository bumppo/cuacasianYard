package repository;

import model.User;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by VMoskalik on 03.03.2016.
 */
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Override
    List<User> findAll(Sort sort);

    @Override
    User findOne(Integer id);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.meals WHERE u.id = ?1")
    User getWithMeals(Integer id);

    @Override
    User save(User user);

    @Modifying
    @Query("DELETE FROM User u WHERE u.id = ?1")
    int delete(int id);
}
