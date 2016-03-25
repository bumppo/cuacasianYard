package caucasianYard.service;

import caucasianYard.model.Money;
import caucasianYard.to.TOMoney;

/**
 * Created by VMoskalik on 21.03.2016.
 */
public interface MoneyService {

    public TOMoney get();

    Money save(Money money);
}
