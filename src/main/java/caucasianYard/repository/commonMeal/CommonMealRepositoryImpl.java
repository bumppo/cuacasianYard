package caucasianYard.repository.commonMeal;

import caucasianYard.model.CommonMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vitaly Moskalik
 *         created on 28.07.2016
 */
@Repository
public class CommonMealRepositoryImpl implements CommonMealRepository {


    private ProxyCommonMealRepository proxy;

    public CommonMealRepositoryImpl() {
    }

    @Autowired
    public CommonMealRepositoryImpl(ProxyCommonMealRepository proxy) {
        this.proxy = proxy;
    }

    @Override
    public List<CommonMeal> getAll() {
        return proxy.findAll();
    }

    @Override
    public CommonMeal get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public CommonMeal save(CommonMeal commonMeal) {
        return proxy.save(commonMeal);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

//    @Override
//    public int getTotalSum() {
//        return 0;
//    }
}
