package web;

import model.Meal;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MealService;
import service.MoneyService;
import service.UserService;
import to.TOMoney;

import java.util.List;

/**
 * Created by vmoskalik on 14.03.2016.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private MealService mealService;

    @Autowired
    private MoneyService moneyService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("userList", service.getAll());
        return "userList";
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") int id){
        User user = service.getWithMeals(id);
        if (user == null){
            model.addAttribute("user", service.get(id));
            return "userWithOutMeal";
        } else {
            List<Meal> mealList = mealService.getAll();
            TOMoney toMoney = moneyService.get();

            int sumWithOutDiscount = 0;
            for (int i = 0; i < mealList.size(); i++) {
                sumWithOutDiscount += mealList.get(i).getCost();
            }
            toMoney.setSumWithOutDiscount(sumWithOutDiscount);
            toMoney.setSumWithDiscount(sumWithOutDiscount + toMoney.getLucky());
            toMoney.setTips(toMoney.getPayed() - toMoney.getSumWithDiscount());
            toMoney.setDiscount((float)-toMoney.getLucky()/toMoney.getSumWithOutDiscount()*100);

            model.addAttribute("tipsPerUser", (float)toMoney.getTips()/service.getAll().size());
            model.addAttribute("toMoney", toMoney);
            model.addAttribute("user", user);
            return "user";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model){
        model.addAttribute("user", new User());
        return "userEdit-333";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(Model model, @RequestParam("id") int id){
        model.addAttribute("user", service.get(id));
        return "userEdit-333";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdate(@RequestParam(value = "id", required = false) Integer id, @RequestParam("name") String name){
        User user = new User(id, name);
        service.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:/users";
    }
}
