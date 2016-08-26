package caucasianYard.web.vaadin.view.order;

import caucasianYard.model.CommonMeal;
import caucasianYard.model.Meal;
import caucasianYard.service.CommonMealService;
import caucasianYard.service.MealService;
import caucasianYard.service.MenuMealService;
import caucasianYard.service.UserService;
import caucasianYard.web.vaadin.utils.Utils;
import com.vaadin.data.util.BeanItemContainer;
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
public class OrderView extends VerticalLayout implements View {

    MealService mealService;
    UserService userService;
    MenuMealService menuMealService;
    CommonMealService commonMealService;

    Meal selectedMeal;
    CommonMeal selectedCommonMeal;
    private BeanItemContainer<Meal> mealBeanItemContainer = new BeanItemContainer<>(Meal.class);
    private BeanItemContainer<CommonMeal> commonMealBeanItemContainer = new BeanItemContainer<>(CommonMeal.class);

    private HorizontalLayout mealLayout = new HorizontalLayout();
    private HorizontalLayout commonMealLayout = new HorizontalLayout();

    MealEdit mealEdit = new MealEdit(this);
    MealForm mealForm = new MealForm(this);
    CommonMealEdit commonMealEdit = new CommonMealEdit(this);
    CommonMealForm commonMealForm = new CommonMealForm(this);

    Grid mealGrid = new Grid("Индивидуальные блюда");
    Grid commonMealGrid = new Grid("Общие блюда");

    private Button addNewMeal = new Button("Добавить блюдо");
    private Button addNewCommonMeal = new Button("Добавить общее блюдо");

    public OrderView() {
        Utils.addObjectToContext(this);
    }

    @PostConstruct
    @Autowired
    private void setServices(MealService mealService, UserService userService, MenuMealService menuMealService, CommonMealService commonMealService) {
        this.mealService = mealService;
        this.userService = userService;
        this.menuMealService = menuMealService;
        this.commonMealService = commonMealService;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setWidthUndefined();
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
        /** Button addNewCommon */
        addNewCommonMeal.setStyleName(ValoTheme.BUTTON_PRIMARY);
        addNewCommonMeal.addClickListener(click -> {
            deselectAll();
            selectedCommonMeal = new CommonMeal();
            selectedCommonMeal.setCost(0);
            commonMealForm.setMeal();
            commonMealForm.setVisible(true);
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
        mealGrid.setHeightMode(HeightMode.ROW);
        /** CommonMeal Grid */
        updateCommonMealGrid();
        commonMealGrid.addSelectionListener(select -> {
            if (select.getSelected().isEmpty()){
                deselectAll();
            } else {
                selectedCommonMeal = (CommonMeal)select.getSelected().iterator().next();
                commonMealForm.setMeal();
                commonMealEdit.setVisible(true);
            }
        });
        commonMealGrid.setHeightMode(HeightMode.ROW);

        VerticalLayout editing = new VerticalLayout(addNewMeal, mealEdit, mealForm);
        editing.setSpacing(true);
        VerticalLayout commonEditing = new VerticalLayout(addNewCommonMeal, commonMealEdit, commonMealForm);
        commonEditing.setSpacing(true);

        mealLayout.addComponents(mealGrid, editing);
        mealLayout.setSpacing(true);
        mealLayout.setWidth(100, Unit.PERCENTAGE);
        commonMealLayout.addComponents(commonMealGrid, commonEditing);
        commonMealLayout.setSpacing(true);
        commonMealLayout.setWidth(100, Unit.PERCENTAGE);

        addComponents(mealLayout, commonMealLayout);
    }

    void updateGrid(){
        mealBeanItemContainer.removeAllItems();
        mealBeanItemContainer.addAll(mealService.getAll());
        mealGrid.setContainerDataSource(mealBeanItemContainer);
        mealGrid.setColumns("description", "cost", "user");
        mealGrid.setHeightByRows(mealBeanItemContainer.size());
    }

    void updateCommonMealGrid(){
        commonMealBeanItemContainer.removeAllItems();
        commonMealBeanItemContainer.addAll(commonMealService.getAll());
        commonMealGrid.setContainerDataSource(commonMealBeanItemContainer);
        commonMealGrid.setColumns("description", "cost", "users");
        commonMealGrid.setHeightByRows(commonMealBeanItemContainer.size());
    }

    void deselectAll(){
        selectedMeal = null;
        mealGrid.deselectAll();
        mealEdit.setVisible(false);
        mealForm.setVisible(false);
        selectedCommonMeal = null;
        commonMealGrid.deselectAll();
        commonMealEdit.setVisible(false);
        commonMealForm.setVisible(false);
    }
}
