package caucasianYard.web.vaadin.view.order;

import javassist.NotFoundException;

/**
 * @author Vitaly Moskalik
 *         created on 26.07.2016
 */
class MealEdit extends AbstractEdit {

    MealEdit(OrderView view) {
        this.view = view;
    }

    @Override
    void edit() {
        view.mealForm.setVisible(true);
    }

    @Override
    void delete() {
        try {
            view.mealService.delete(view.selectedMeal.getId());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        view.updateGrid();
        view.deselectAll();
    }
}
