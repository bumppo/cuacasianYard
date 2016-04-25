package caucasianYard.web;

import caucasianYard.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by VMoskalik on 25.04.2016.
 */

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    MenuService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("menu", service.getAll());
        return "menu";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("menu", service.getAll());
        model.addAttribute("menuChoosen", service.getWithMenuMeals(id));
        return "menuChoosen";
    }
}
