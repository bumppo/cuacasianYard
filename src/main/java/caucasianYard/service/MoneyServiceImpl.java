package caucasianYard.service;

import caucasianYard.model.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import caucasianYard.repository.money.MoneyRepository;
import caucasianYard.to.TOMoney;

/**
 * Created by VMoskalik on 21.03.2016.
 */
@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    MoneyRepository repository;

    @Override
    public TOMoney get() {
        return repository.get();
    }

    @Override
    public Money save(Money money) {
        return repository.save(money);
    }
}
