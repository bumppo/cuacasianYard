package web;

import model.Meal;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import service.MealService;
import service.UserService;
import util.UserPropertyEditor;

/**
 * Created by VMoskalik on 18.03.2016.
 */
@Controller
@RequestMapping(value = "/meals")
public class MealController {

    @Autowired
    MealService service;

    @Autowired
    UserService userService;

    @InitBinder
    public void initBinderUser(WebDataBinder binder){
        binder.registerCustomEditor(User.class, new UserPropertyEditor());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("mealList", service.getAll());
        return "mealList";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") int id){
        model.addAttribute("meal", service.get(id));
        return "meal";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model){
        model.addAttribute("meal", new Meal());
        model.addAttribute("userList", userService.getAll());
        return "mealEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(Model model, @RequestParam("id") int id){
        model.addAttribute("meal", service.get(id));
        model.addAttribute("userList", userService.getAll());
        return "mealEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdate(@ModelAttribute("meal") Meal mealFromForm) {
        service.save(mealFromForm);
        return "redirect:/meals";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String createOrUpdate(@RequestParam(value = "id", required = false) int id,
//                                 @RequestParam("user_id") int user_id,
//                                 @RequestParam("description") String description,
//                                 @RequestParam("cost") int cost) {
//        Meal mealFromForm = new Meal(id, description, cost);
//        mealFromForm.setUser(userService.get(user_id));
//        service.save(mealFromForm);
//        return "redirect:/meals";
//    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:/meals";
    }
}