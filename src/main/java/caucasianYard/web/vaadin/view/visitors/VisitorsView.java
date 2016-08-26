package caucasianYard.web.vaadin.view.visitors;

import caucasianYard.model.User;
import caucasianYard.service.UserService;
import caucasianYard.web.vaadin.utils.Utils;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

/**
 * @author Vitaly Moskalik
 *         created on 15.07.2016
 */
public class VisitorsView extends HorizontalLayout implements View {

    UserService userService;
    User selectedUser;
    private BeanItemContainer<User> userBeanItemContainer = new BeanItemContainer<>(User.class);

    private VisitorEdit visitorEdit = new VisitorEdit(this);
    VisitorForm visitorForm = new VisitorForm(this);
    private Grid grid = new Grid("Посетители");
    private Button addNew = new Button("Добавить посетителя");
    private VerticalLayout editing = new VerticalLayout();

    public VisitorsView() {
        Utils.addObjectToContext(this);
    }

    @PostConstruct
    @Autowired
    private void setServices(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setSpacing(true);

        /** AddNew Button */
        addNew.setStyleName(ValoTheme.BUTTON_PRIMARY);
        addNew.addClickListener(click -> {
            deselectAll();
            selectedUser = new User();
            visitorForm.setUser();
            visitorForm.setVisible(true);
        });

        /** Grid */
        updateGrid();
        grid.addSelectionListener(select -> {
            if (select.getSelected().isEmpty()){
                deselectAll();
            } else{
                selectedUser = (User)select.getSelected().iterator().next();
                visitorForm.setUser();
                visitorEdit.setVisible(true);
            }
        });
        grid.addShortcutListener(new ShortcutListener("", ShortcutAction.KeyCode.ESCAPE, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                deselectAll();
            }
        });
        grid.setHeightMode(HeightMode.ROW);

        visitorEdit.setVisible(false);
        visitorForm.setVisible(false);

        editing.addComponents(addNew, visitorEdit, visitorForm);
        editing.setSpacing(true);
        addComponents(grid, editing);
    }

    void updateGrid(){
        userBeanItemContainer.removeAllItems();
        userBeanItemContainer.addAll(userService.getAll());
        grid.setContainerDataSource(userBeanItemContainer);
        grid.setColumns("name");
        Grid.Column nameColumn = grid.getColumn("name");
        nameColumn.setHeaderCaption("Имя");
        grid.setHeightByRows(userBeanItemContainer.size());
    }

    void deselectAll(){
        selectedUser = null;
        grid.deselectAll();
        visitorForm.setVisible(false);
        visitorEdit.setVisible(false);
    }
}
