package caucasianYard.service;

import caucasianYard.model.CommonMeal;
import caucasianYard.repository.commonMeal.CommonMealRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Vitaly Moskalik
 *         created on 24.08.2016
 */
@Service
@Transactional
public class CommonMealServiceImpl implements CommonMealService {

    @Autowired
    CommonMealRepository repository;

    @Override
    public List<CommonMeal> getAll() {
        return repository.getAll();
    }

    @Override
    public CommonMeal get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public CommonMeal save(CommonMeal commonMeal) {
        return repository.save(commonMeal);
    }

    @Override
    public void update(CommonMeal commonMeal) {
        repository.save(commonMeal);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }
}
