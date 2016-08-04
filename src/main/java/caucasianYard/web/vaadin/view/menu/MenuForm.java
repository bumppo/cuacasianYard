package caucasianYard.web.vaadin.view.menu;

import caucasianYard.model.MenuMeal;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import elemental.events.KeyboardEvent;

/**
 * @author Vitaly Moskalik
 *         created on 19.07.2016
 */
class MenuForm extends FormLayout {

    private MenuView view;
    private BeanFieldGroup<MenuMeal> mealBeanFieldGroup;

    private TextField description = new TextField("Название");
    private TextField cost = new TextField("Цена");

    MenuForm(MenuView view) {
        this.view = view;
        setVisible(false);

        Button save = new Button("Сохранить");
        Button cancel = new Button("Отмена");

        cost.setConverter(new StringToIntegerConverter());

        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        save.addClickListener(event -> this.save());
        save.setClickShortcut(KeyboardEvent.KeyCode.ENTER);

        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        cancel.addClickListener(event -> this.cancel());

        HorizontalLayout buttons = new HorizontalLayout(save, cancel);
        buttons.setSpacing(true);
        addComponents(description, cost, buttons);
    }

    void setMeal(){
        mealBeanFieldGroup = BeanFieldGroup.bindFieldsBuffered(view.selectedMenuMeal, this);
    }

    private void save(){
        try {
            mealBeanFieldGroup.commit();
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }
        view.menuMealService.save(view.selectedMenuMeal);
        view.updateGrid();
        view.deselectAll();
    }

    private void cancel(){
        view.deselectAll();
    }
}
