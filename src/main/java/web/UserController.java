package web;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

/**
 * Created by vmoskalik on 14.03.2016.
 */
@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("userList", service.getAll());
        return "userList";
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") int id){
        model.addAttribute("user", service.get(id));
        return "user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model){
        model.addAttribute("user", new User());
        return "userEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(Model model, @RequestParam("id") int id){
        model.addAttribute("user", service.get(id));
        return "userEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdate(@RequestParam("id") int id, @RequestParam("name") String name){
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
