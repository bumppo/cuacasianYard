package caucasianYard.web.vaadin.view.visitors;

import caucasianYard.model.User;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
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
class VisitorForm extends FormLayout {

    private VisitorsView view;
    private BeanFieldGroup<User> userBeanFieldGroup;

    private TextField name = new TextField("Имя");

    VisitorForm(VisitorsView view) {
        this.view = view;

        name.setInputPrompt("...");

        Button save = new Button("Сохранить");
        Button cancel = new Button("Отмена");

        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        save.addClickListener(event -> this.save());
        save.setClickShortcut(KeyboardEvent.KeyCode.ENTER);

        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        cancel.addClickListener(event -> this.cancel());

        HorizontalLayout buttons = new HorizontalLayout(save, cancel);
        buttons.setSpacing(true);
        addComponents(name, buttons);
    }

    void setUser(){
        userBeanFieldGroup = BeanFieldGroup.bindFieldsBuffered(view.selectedUser, this);
    }

    private void save(){
        try {
            userBeanFieldGroup.commit();
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }
        view.userService.save(view.selectedUser);
        view.deselectAll();
        view.updateGrid();
    }

    private void cancel(){
        view.deselectAll();
    }
}