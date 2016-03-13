package repository;

import model.User;
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
    User save(User user);

    @Modifying
    @Query("DELETE FROM User u WHERE u.id = ?1")
    int delete(int id);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll(Sort sort);
}
