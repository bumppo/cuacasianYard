package caucasianYard.web;

import caucasianYard.model.Meal;
import caucasianYard.model.User;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import caucasianYard.service.MealService;
import caucasianYard.service.MoneyService;
import caucasianYard.service.UserService;
import caucasianYard.to.TOMoney;
import caucasianYard.util.UserPropertyEditor;

import java.util.List;


@Controller
@RequestMapping(value = "/meals")
public class MealController {

    @Autowired
    MealService service;

    @Autowired
    UserService userService;

    @Autowired
    MoneyService moneyService;

    @InitBinder
    public void initBinderUser(WebDataBinder binder){
        binder.registerCustomEditor(User.class, new UserPropertyEditor());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        List<Meal> mealList = service.getAll();
        TOMoney toMoney = moneyService.get();

        int sumWithOutDiscount = 0;
        for (Meal meal : mealList) {
            sumWithOutDiscount += meal.getCost();
        }
        toMoney.setSumWithOutDiscount(sumWithOutDiscount);
        toMoney.setSumWithDiscount(sumWithOutDiscount + toMoney.getLucky());
        toMoney.setTips(toMoney.getPayed() - toMoney.getSumWithDiscount());
        toMoney.setDiscount((float)-toMoney.getLucky()/toMoney.getSumWithOutDiscount()*100);

        model.addAttribute("toMoney", toMoney);
        model.addAttribute("mealList", mealList);
        return "mealList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model){
        model.addAttribute("meal", new Meal());
        model.addAttribute("userList", userService.getAll());
        return "mealEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(Model model, @RequestParam("id") int id){
        try {
            model.addAttribute("meal", service.get(id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("userList", userService.getAll());
        return "mealEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdate(@ModelAttribute("meal") Meal mealFromForm) {
        service.save(mealFromForm);
        return "redirect:/meals";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id){
        try {
            service.delete(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/meals";
    }
}
