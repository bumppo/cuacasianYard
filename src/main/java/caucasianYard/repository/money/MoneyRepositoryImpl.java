package caucasianYard.repository.money;

import caucasianYard.model.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import caucasianYard.to.TOMoney;

/**
 * Created by VMoskalik on 21.03.2016.
 */
@Repository
public class MoneyRepositoryImpl implements MoneyRepository {

    @Autowired
    ProxyMoneyRepository proxy;

    // return TOMoney from the only Money row
    @Override
    public TOMoney get() {
        Money money = DataAccessUtils.singleResult(proxy.findAll());
        return new TOMoney(money.getId(), money.getPayed(), money.getLucky());
    }

    @Override
    public Money save(Money money) {
        return proxy.save(money);
    }
}
