package caucasianYard.web.vaadin.view.order;

import caucasianYard.model.Meal;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ListSelect;

/**
 * @author Vitaly Moskalik
 *         created on 26.07.2016
 */
class MealForm extends AbstractForm<Meal> {

    private ListSelect user = new ListSelect("Посетитель");

    MealForm(OrderView view) {
        this.view = view;

        user.setContainerDataSource(userContainer);
        user.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        user.setItemCaptionPropertyId("name");

        addComponent(user, 2);
    }

    @Override
    void setMeal() {
        super.setMeal();
        beanFieldGroup = BeanFieldGroup.bindFieldsBuffered(view.selectedMeal, this);
        cost.setEnabled(false);
    }

    @Override
    void save() {
        try {
            beanFieldGroup.commit();
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }
        view.mealService.save(view.selectedMeal);
        view.updateGrid();
        view.deselectAll();
    }

    @Override
    void cancel() {
        view.deselectAll();
    }
}
