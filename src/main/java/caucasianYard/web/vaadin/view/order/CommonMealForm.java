package caucasianYard.web.vaadin.view.order;

import caucasianYard.model.CommonMeal;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.OptionGroup;

/**
 * @author Vitaly Moskalik
 *         created on 27.07.2016
 */
public class CommonMealForm extends AbstractForm<CommonMeal> {

    private OptionGroup users = new OptionGroup("Посетители");

    public CommonMealForm(OrderView view) {
        this.view = view;



        addComponent(users, 2);
    }

    @Override
    void setMeal() {
        super.setMeal();
        beanFieldGroup = BeanFieldGroup.bindFieldsBuffered(view.selectedCommonMeal, this);
        cost.setEnabled(false);
    }

    @Override
    void save() {
        try {
            beanFieldGroup.commit();
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }
        //service.save();
        view.updateGrid();
        view.deselectAll();
    }

    @Override
    void cancel() {
        view.deselectAll();
    }
}
