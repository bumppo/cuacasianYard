package caucasianYard.web.vaadin.view.order;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Vitaly Moskalik
 *         created on 26.07.2016
 */
abstract class AbstractEdit extends HorizontalLayout {

    OrderView view;

    AbstractEdit() {
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

    void edit(){}

    void delete(){}
}
