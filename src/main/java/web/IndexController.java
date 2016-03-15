package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vmoskalik on 15.03.2016.
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(){
        return "index";
    }
}
