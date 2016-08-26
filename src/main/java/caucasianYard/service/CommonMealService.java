package caucasianYard.service;

import caucasianYard.model.CommonMeal;
import javassist.NotFoundException;
import java.util.List;

/**
 * @author Vitaly Moskalik
 *         created on 24.08.2016
 */
public interface CommonMealService {

    List<CommonMeal> getAll();

    CommonMeal get (int id) throws NotFoundException;

    CommonMeal save(CommonMeal commonMeal);

    void update (CommonMeal commonMeal);

    void delete(int id) throws NotFoundException;

}
