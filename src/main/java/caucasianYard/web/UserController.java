package caucasianYard.web;

import caucasianYard.model.Meal;
import caucasianYard.model.User;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import caucasianYard.service.MealService;
import caucasianYard.service.MoneyService;
import caucasianYard.service.UserService;
import caucasianYard.dto.MoneyDTO;

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
        model.addAttribute("user", user);
        if (user.getMeals().size() == 0){
            return "userWithOutMeal";
        } else {
            List<Meal> mealList = mealService.getAll();
            MoneyDTO moneyDTO = moneyService.get();

            int sumWithOutDiscount = 0;
            for (Meal meal : mealList) {
                sumWithOutDiscount += meal.getCost();
            }
            moneyDTO.setSumWithOutDiscount(sumWithOutDiscount);
            moneyDTO.setSumWithDiscount(sumWithOutDiscount + moneyDTO.getLucky());
            moneyDTO.setTips(moneyDTO.getPayed() - moneyDTO.getSumWithDiscount());
            moneyDTO.setDiscount((float)-moneyDTO.getLucky()/ moneyDTO.getSumWithOutDiscount()*100);

            model.addAttribute("tipsPerUser", (float) moneyDTO.getTips()/service.getAll().size());
            model.addAttribute("toMoney", moneyDTO);
            return "user";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model){
        model.addAttribute("user", new User());
        return "userEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(Model model, @RequestParam("id") int id){
        try {
            model.addAttribute("user", service.get(id));
        } catch (NotFoundException e){
            e.printStackTrace();
        }
        return "userEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdate(@RequestParam(value = "id", required = false) Integer id, @RequestParam("name") String name){
        User user = new User(id, name);
        service.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id){
        try {
            service.delete(id);
        } catch (NotFoundException e){
            e.printStackTrace();
        }
        return "redirect:/users";
    }
}
