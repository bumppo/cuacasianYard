package service;

import model.Money;
import to.TOMoney;

/**
 * Created by VMoskalik on 21.03.2016.
 */
public interface MoneyService {

    public TOMoney get();

    Money save(Money money);
}
