package caucasianYard.web.vaadin.view.bill;

import caucasianYard.dto.MoneyDTO;
import caucasianYard.service.MoneyService;
import caucasianYard.web.vaadin.utils.Utils;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

/**
 * @author Vitaly Moskalik
 *         created on 15.07.2016
 */
public class BillView extends VerticalLayout implements View {

    MoneyService moneyService;
    private BeanItemContainer<MoneyDTO> moneyBeanItemContainer = new BeanItemContainer<>(MoneyDTO.class);

    private FormLayout billForm;
    private Grid grid = new Grid("Информация по счету");

    public BillView() {
        Utils.addObjectToContext(this);
    }

    @PostConstruct
    @Autowired
    private void addServices(MoneyService moneyService){
        this.moneyService = moneyService;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setSpacing(true);

        billForm = new BillForm(this);

        updateGrid();

        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addComponents(billForm, grid);
    }

    void updateGrid(){
        moneyBeanItemContainer.removeAllItems();
        moneyBeanItemContainer.addBean(moneyService.get());
        grid.setContainerDataSource(moneyBeanItemContainer);
    }
}
