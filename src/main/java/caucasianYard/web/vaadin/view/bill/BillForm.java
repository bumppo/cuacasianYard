package caucasianYard.web.vaadin.view.bill;

import caucasianYard.dto.MoneyDTO;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import elemental.events.KeyboardEvent;

/**
 * @author Vitaly Moskalik
 *         created on 19.07.2016
 */
public class BillForm extends FormLayout {

    private BillView view;
    private BeanFieldGroup<MoneyDTO> moneyBeanFieldGroup;

    private TextField payed = new TextField("Заплачено фактически");
    private TextField lucky = new TextField("Счастливые часы");
    private Button save = new Button("Сохранить");

    public BillForm(BillView view) {
        this.view = view;

        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        save.addClickListener(event -> this.save());
        save.setClickShortcut(KeyboardEvent.KeyCode.ENTER);
        addComponents(payed, lucky, save);

        moneyBeanFieldGroup = BeanFieldGroup.bindFieldsBuffered(view.moneyService.get(), this);
    }

    private void save(){
        try {
            moneyBeanFieldGroup.commit();
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }
        view.moneyService.save(moneyBeanFieldGroup.getItemDataSource().getBean());
        view.updateGrid();
    }
}
