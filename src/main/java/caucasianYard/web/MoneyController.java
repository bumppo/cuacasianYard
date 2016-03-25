package caucasianYard.web;

import caucasianYard.model.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import caucasianYard.service.MoneyService;
import caucasianYard.to.TOMoney;

/**
 * Created by VMoskalik on 21.03.2016.
 */
@Controller
@RequestMapping(value = "/money")
public class MoneyController {

    @Autowired
    MoneyService service;

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute("toMoney") TOMoney to){
        service.save(new Money(to.getId(), to.getPayed(), to.getLucky()));
        return "redirect:/meals";
    }
}
