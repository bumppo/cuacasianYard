package caucasianYard.repository.money;

import caucasianYard.model.Money;
import caucasianYard.dto.MoneyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

/**
 * Created by VMoskalik on 21.03.2016.
 */
@Repository
public class MoneyRepositoryImpl implements MoneyRepository {

    @Autowired
    ProxyMoneyRepository proxy;

    // return MoneyDTO from the only Money row
    @Override
    public Money get() {
        return DataAccessUtils.singleResult(proxy.findAll());
    }

    @Override
    public Money save(Money money) {
        return proxy.save(money);
    }
}
