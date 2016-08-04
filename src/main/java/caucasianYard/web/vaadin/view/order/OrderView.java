package caucasianYard.web.vaadin.view.order;

import caucasianYard.model.CommonMeal;
import caucasianYard.model.Meal;
import caucasianYard.service.MealService;
import caucasianYard.service.MenuMealService;
import caucasianYard.service.UserService;
import caucasianYard.web.vaadin.utils.Utils;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Vitaly Moskalik
 *         created on 15.07.2016
 */
public class OrderView extends VerticalLayout implements View {

    MealService mealService;
    UserService userService;
    MenuMealService menuMealService;

    Meal selectedMeal;
    CommonMeal selectedCommonMeal;
    private BeanItemContainer<Meal> mealBeanItemContainer = new BeanItemContainer<>(Meal.class);
    private BeanItemContainer<CommonMeal> commonMealBeanItemContainer = new BeanItemContainer<>(CommonMeal.class);

    private HorizontalLayout mealLayout = new HorizontalLayout();
    private HorizontalLayout commonMealLayout = new HorizontalLayout();

    MealEdit mealEdit = new MealEdit(this);
    MealForm mealForm = new MealForm(this);

    Grid mealGrid = new Grid("Индивидуальные блюда");
    Grid commonMealGrid = new Grid("Общие блюда");

    private Button addNewMeal = new Button("Добавить блюдо");
    private Button addNewCommonMeal = new Button("Добавить общее блюдо");

    public OrderView() {
        Utils.addObjectToContext(this);
    }

    @PostConstruct
    @Autowired
    private void setServices(MealService mealService, UserService userService, MenuMealService menuMealService) {
        this.mealService = mealService;
        this.userService = userService;
        this.menuMealService = menuMealService;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setSpacing(true);

        /** Button addNew */
        addNewMeal.setStyleName(ValoTheme.BUTTON_PRIMARY);
        addNewMeal.addClickListener(click -> {
            deselectAll();
            selectedMeal = new Meal();
            selectedMeal.setCost(0);
            mealForm.setMeal();
            mealForm.setVisible(true);
        });

        /** Grid */
        updateGrid();
        mealGrid.addSelectionListener(select -> {
            if (select.getSelected().isEmpty()){
                deselectAll();
            } else {
                selectedMeal = (Meal)select.getSelected().iterator().next();
                mealForm.setMeal();
                mealEdit.setVisible(true);
            }
        });

        VerticalLayout editing = new VerticalLayout(addNewMeal, mealEdit, mealForm);
        editing.setSpacing(true);

        mealLayout.addComponents(mealGrid, editing);
        mealLayout.setSpacing(true);

        addComponents(mealLayout);
    }

    void updateGrid(){
        mealBeanItemContainer.removeAllItems();
        mealBeanItemContainer.addAll(mealService.getAll());
        mealGrid.setContainerDataSource(mealBeanItemContainer);
        mealGrid.setColumns("description", "cost", "user");
    }

    void deselectAll(){
        selectedMeal = null;
        mealGrid.deselectAll();
        mealEdit.setVisible(false);
        mealForm.setVisible(false);
    }
}
