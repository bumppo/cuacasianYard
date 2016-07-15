package caucasianYard.web;

import caucasianYard.model.Meal;
import caucasianYard.model.MenuMeal;
import caucasianYard.service.MenuMealService;
import caucasianYard.service.MenuService;
import caucasianYard.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by VMoskalik on 26.04.2016.
 */

@Controller
@RequestMapping(value = "/menuMeal")
public class MenuMealController {

    @Autowired
    MenuMealService service;

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model, @RequestParam("menuId") int menuId){
        MenuMeal menuMeal = new MenuMeal();
//        menuMeal.setMenu(menuService.get(menuId));
        model.addAttribute("menuMeal", new MenuMeal());
        return "menuMealEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(Model model, @RequestParam("id") int id){
        try {
            model.addAttribute("menuMeal", service.get(id));
        } catch (NotFoundException e){
            e.printStackTrace();
        }
        return "menuMealEdit";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String editForBuy(Model model, @RequestParam("id") int id, @RequestParam("menuId") int menuId){
        Meal meal = new Meal();
        MenuMeal menuMeal = new MenuMeal();
        try {
            menuMeal = service.get(id);
        } catch (NotFoundException e){
            e.printStackTrace();
        }
        meal.setDescription(menuMeal.getDescription());
        meal.setCost(menuMeal.getCost());

        model.addAttribute("meal", meal);
        model.addAttribute("menuId", menuId);
        model.addAttribute("userList", userService.getAll());
        return "/mealEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdate(@ModelAttribute("menuMeal") MenuMeal menuMeal){
        service.save(menuMeal);
        return "redirect:/menu";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id){
        try {
            service.delete(id);
        } catch (NotFoundException e){
            e.printStackTrace();
        }
        return "redirect:/menu";
    }
}
