package caucasianYard.web.vaadin.view.order;

import caucasianYard.model.CommonMeal;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ListSelect;

/**
 * @author Vitaly Moskalik
 *         created on 27.07.2016
 */
public class CommonMealForm extends AbstractForm<CommonMeal> {

    private ListSelect users = new ListSelect("Посетители");

    public CommonMealForm(OrderView view) {
        this.view = view;

        users.setMultiSelect(true);
        users.setContainerDataSource(userContainer);
        users.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        users.setItemCaptionPropertyId("name");

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
        view.commonMealService.save(view.selectedCommonMeal);
        view.updateGrid();
        view.deselectAll();
    }

    @Override
    void cancel() {
        view.deselectAll();
    }
}
