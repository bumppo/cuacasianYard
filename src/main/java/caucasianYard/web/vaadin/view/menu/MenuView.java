package caucasianYard.web.vaadin.view.menu;

import caucasianYard.model.Menu;
import caucasianYard.model.MenuMeal;
import caucasianYard.service.MenuMealService;
import caucasianYard.service.MenuService;
import caucasianYard.web.vaadin.utils.Utils;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Vitaly Moskalik
 *         created on 15.07.2016
 */
public class MenuView extends HorizontalLayout implements View {

    MenuMealService menuMealService;
    private MenuService menuService;
    MenuMeal selectedMenuMeal;

    private MenuEdit menuEdit = new MenuEdit(this);
    MenuForm menuForm = new MenuForm(this);
    private Accordion accordion = new Accordion();
    private Button addNew = new Button("Добавить блюдо");
    private VerticalLayout editing = new VerticalLayout();

    public MenuView() {
        Utils.addObjectToContext(this);
    }

    @PostConstruct
    @Autowired
    private void setServices(MenuService menuService, MenuMealService mealService){
        this.menuService = menuService;
        this.menuMealService = mealService;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setSpacing(true);

        /** Accordion accordion */
        for (Menu menu : menuService.getAll()) {
            accordion.addTab(new LayoutWithGrid(menu), menu.getName()).setDescription(String.valueOf(menu.getId()));
        }
//        accordion.setStyleName(ValoTheme.TABSHEET_FRAMED + " " + ValoTheme.TABSHEET_EQUAL_WIDTH_TABS);
        accordion.addSelectedTabChangeListener(select -> deselectAll());
        accordion.addShortcutListener(new ShortcutListener("deselectAll", ShortcutAction.KeyCode.ESCAPE, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                deselectAll();
            }
        });

        /** Button addNew */
        addNew.setStyleName(ValoTheme.BUTTON_PRIMARY);
        addNew.addClickListener(click -> {
            deselectAll();
            selectedMenuMeal = new MenuMeal();
            selectedMenuMeal.setMenu(menuService.get(Integer.parseInt(accordion.getTab(accordion.getSelectedTab()).getDescription())));
            selectedMenuMeal.setCost(0);
            menuForm.setMeal();
            menuForm.setVisible(true);
        });

        editing.setSpacing(true);
        editing.addComponents(addNew, menuEdit, menuForm);

        addComponents(accordion, editing);
    }

    void updateGrid(){
        Component current = accordion.getSelectedTab();
        accordion.replaceComponent(current, new LayoutWithGrid(menuService.get(Integer.parseInt(accordion.getTab(current).getDescription()))));
    }


    void deselectAll(){
        ((LayoutWithGrid)accordion.getSelectedTab()).grid.deselectAll();
        selectedMenuMeal = null;
        menuEdit.setVisible(false);
        menuForm.setVisible(false);
    }

    private class LayoutWithGrid extends VerticalLayout {

        private Grid grid = new Grid();

        private LayoutWithGrid(Menu menu) {
            grid.setContainerDataSource(new BeanItemContainer<>(MenuMeal.class, menu.getMenuMeals()));

            grid.addSelectionListener(select -> {
                if (select.getSelected().isEmpty()) {
                    deselectAll();
                } else {
                    selectedMenuMeal = (MenuMeal)select.getSelected().iterator().next();
                    menuForm.setMeal();
                    menuEdit.setVisible(true);
                }
            });
            grid.setColumns("description", "cost");

            addComponent(grid);
        }
    }
}
