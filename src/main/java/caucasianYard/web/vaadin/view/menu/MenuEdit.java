package caucasianYard.web.vaadin.view.menu;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javassist.NotFoundException;

/**
 * @author Vitaly Moskalik
 *         created on 19.07.2016
 */
class MenuEdit extends HorizontalLayout{

    private MenuView view;

    MenuEdit(MenuView view) {
        this.view = view;
        setSpacing(true);
        setVisible(false);

        Button edit = new Button("Изменить");
        Button delete = new Button("Удалить");

        edit.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        edit.addClickListener(event -> this.edit());

        delete.setStyleName(ValoTheme.BUTTON_DANGER);
        delete.addClickListener(event -> this.delete());

        addComponents(edit, delete);
    }

    private void edit(){
        view.menuForm.setVisible(true);
    }

    private void delete(){
        try {
            view.menuMealService.delete(view.selectedMenuMeal.getId());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        view.updateGrid();
        view.deselectAll();
    }
}
