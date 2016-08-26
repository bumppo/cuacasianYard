package caucasianYard.web.vaadin.view.order;

import caucasianYard.model.BaseEntity;
import caucasianYard.model.MenuMeal;
import caucasianYard.model.User;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import elemental.events.KeyboardEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vitaly Moskalik
 *         created on 26.07.2016
 */
abstract class AbstractForm<E extends BaseEntity> extends FormLayout {

    OrderView view;
    BeanFieldGroup<E> beanFieldGroup;
    BeanItemContainer<User> userContainer = new BeanItemContainer<>(User.class);
    BeanItemContainer<String> menuMealContainer = new BeanItemContainer<>(String.class);
    Map<String, Integer> menuMeals = new HashMap<>();

    ComboBox description = new ComboBox("Название");
    TextField cost = new TextField("Цена");

    AbstractForm() {
        setVisible(false);

        Button save = new Button("Сохранить");
        Button cancel = new Button("Отмена");

        cost.setConverter(new StringToIntegerConverter());

        description.setNullSelectionAllowed(false);
        description.setNewItemsAllowed(false);
        description.setFilteringMode(FilteringMode.CONTAINS);
        description.setContainerDataSource(menuMealContainer);
        description.addValueChangeListener(event -> {
            cost.setEnabled(true);
            cost.setValue(menuMeals.get(event.getProperty().getValue().toString()).toString());
            cost.setEnabled(false);
        });

        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        save.addClickListener(event -> save());
        save.setClickShortcut(KeyboardEvent.KeyCode.ENTER);

        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        cancel.addClickListener(event -> cancel());
        cancel.setClickShortcut(KeyboardEvent.KeyCode.ESC);

        HorizontalLayout buttons = new HorizontalLayout(save, cancel);
        buttons.setSpacing(true);
        addComponents(description, cost, buttons);
    }

    void setMeal(){
        userContainer.removeAllItems();
        userContainer.addAll(view.userService.getAll());

        menuMealContainer.removeAllItems();
        menuMeals.clear();
        for (MenuMeal menuMeal : view.menuMealService.getAll()){
            menuMeals.put(menuMeal.getDescription(), menuMeal.getCost());
        }
        menuMealContainer.addAll(menuMeals.keySet());
    }

    void save(){}

    void cancel(){}
}
