package caucasianYard.repository.commonMeal;

import caucasianYard.model.CommonMeal;

import java.util.List;

/**
 * @author Vitaly Moskalik
 *         created on 28.07.2016
 */
public interface CommonMealRepository {

    List<CommonMeal> getAll();

    CommonMeal get(int id);

    CommonMeal save(CommonMeal commonMeal);

    boolean delete(int id);

//    int getTotalSum();
}
