package caucasianYard.service;

import caucasianYard.model.Money;
import caucasianYard.repository.meal.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import caucasianYard.repository.money.MoneyRepository;
import caucasianYard.dto.MoneyDTO;

/**
 * Created by VMoskalik on 21.03.2016.
 */
@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    MoneyRepository repository;

    @Autowired
    MealRepository mealRepository;

    @Override
    public MoneyDTO get() {
        MoneyDTO moneyDTO = new MoneyDTO(repository.get());
        moneyDTO.setSumWithOutDiscount(mealRepository.getTotalSum());
        moneyDTO.setSumWithDiscount(moneyDTO.getSumWithOutDiscount() + moneyDTO.getLucky());
        moneyDTO.setTips(moneyDTO.getPayed() - moneyDTO.getSumWithDiscount());
        moneyDTO.setDiscount((float)-moneyDTO.getLucky()/ moneyDTO.getSumWithOutDiscount()*100);
        return moneyDTO;
    }

    @Override
    public MoneyDTO save(MoneyDTO moneyDTO) {
        Money money = new Money();
        money.setId(moneyDTO.getId());
        money.setPayed(moneyDTO.getPayed());
        money.setLucky(moneyDTO.getLucky());
        return new MoneyDTO(repository.save(money));
    }
}
