package caucasianYard.repository.commonMeal;

import caucasianYard.model.CommonMeal;
import caucasianYard.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vitaly Moskalik
 *         created on 28.07.2016
 */
public interface ProxyCommonMealRepository extends JpaRepository<CommonMeal, Integer> {

    @Override
    List<CommonMeal> findAll();

    @Override
    CommonMeal findOne(Integer id);

    @Override
    CommonMeal save (CommonMeal commonMeal);

    @Modifying
    @Query("DELETE FROM CommonMeal cm WHERE cm.id = ?1")
    int delete(int id);

//    @Query("SELECT SUM(cm.cost) FROM CommonMeal cm")
//    long getTotalSum();

}
