package caucasianYard.repository.money;

import caucasianYard.model.Money;
import caucasianYard.dto.MoneyDTO;

/**
 * Created by VMoskalik on 21.03.2016.
 */

public interface MoneyRepository {

    Money get();

    Money save(Money money);
}
