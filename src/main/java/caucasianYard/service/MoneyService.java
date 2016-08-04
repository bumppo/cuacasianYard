package caucasianYard.service;

import caucasianYard.dto.MoneyDTO;

/**
 * Created by VMoskalik on 21.03.2016.
 */
public interface MoneyService {

    public MoneyDTO get();

    MoneyDTO save(MoneyDTO moneyDTO);
}
