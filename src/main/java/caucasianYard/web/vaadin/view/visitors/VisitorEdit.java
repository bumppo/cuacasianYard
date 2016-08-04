package caucasianYard.web.vaadin.view.visitors;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javassist.NotFoundException;

/**
 * @author Vitaly Moskalik
 *         created on 19.07.2016
 */
class VisitorEdit extends HorizontalLayout {

    private VisitorsView view;

    VisitorEdit(VisitorsView view) {
        this.view = view;
        setSpacing(true);

        Button edit = new Button("Изменить");
        Button delete = new Button("Удалить");

        edit.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        edit.addClickListener(event -> this.edit());

        delete.setStyleName(ValoTheme.BUTTON_DANGER);
        delete.addClickListener(event -> this.delete());

        addComponents(edit, delete);
    }

    private void edit(){
        view.visitorForm.setVisible(true);
    }

    private void delete(){
        try {
            view.userService.delete(view.selectedUser.getId());
        }
        catch (NotFoundException e){
            e.printStackTrace();
        }
        view.deselectAll();
        view.updateGrid();
    }
}