package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by VMoskalik on 02.03.2016.
 */
@Transactional
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
//    @Query("DELETE FROM User u WHERE u.id = ?1")
    int delete(int id);

    User get(Integer id);

}
