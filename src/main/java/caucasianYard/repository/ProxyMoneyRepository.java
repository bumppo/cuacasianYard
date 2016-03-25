package caucasianYard.repository;

import caucasianYard.model.Money;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by VMoskalik on 21.03.2016.
 */
public interface ProxyMoneyRepository extends JpaRepository<Money, Integer> {

    @Override
    List<Money> findAll();

    @Override
    Money save(Money money);
}
