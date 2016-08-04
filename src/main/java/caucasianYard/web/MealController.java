package caucasianYard.web;

import caucasianYard.model.Meal;
import caucasianYard.model.User;
import caucasianYard.dto.MoneyDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import caucasianYard.service.MealService;
import caucasianYard.service.MoneyService;
import caucasianYard.service.UserService;
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
        MoneyDTO moneyDTO = moneyService.get();

        int sumWithOutDiscount = 0;
        for (Meal meal : mealList) {
            sumWithOutDiscount += meal.getCost();
        }
        moneyDTO.setSumWithOutDiscount(sumWithOutDiscount);
        moneyDTO.setSumWithDiscount(sumWithOutDiscount + moneyDTO.getLucky());
        moneyDTO.setTips(moneyDTO.getPayed() - moneyDTO.getSumWithDiscount());
        moneyDTO.setDiscount((float)-moneyDTO.getLucky()/ moneyDTO.getSumWithOutDiscount()*100);

        model.addAttribute("toMoney", moneyDTO);
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
    public String editForUpdate(Model model, @RequestParam(value = "id") int id){
        try {
            model.addAttribute("meal", service.get(id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("userList", userService.getAll());
        return "mealEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdateOrBuy(@ModelAttribute("meal") Meal mealFromForm, @RequestParam(value = "menuId", required = false) Integer menuId) {
        service.save(mealFromForm);
        if (menuId == null)
            return "redirect:/meals";
        else return "redirect:/menu/" + menuId;
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
