package caucasianYard.web.vaadin.view.order;

import javassist.NotFoundException;

/**
 * @author Vitaly Moskalik
 *         created on 26.07.2016
 */
class CommonMealEdit extends AbstractEdit {

    CommonMealEdit(OrderView view) {
        this.view = view;
    }

    @Override
    void edit() {
        view.commonMealForm.setVisible(true);
    }

    @Override
    void delete() {
        try {
            view.commonMealService.delete(view.selectedCommonMeal.getId());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        view.updateCommonMealGrid();
        view.deselectAll();
    }
}
