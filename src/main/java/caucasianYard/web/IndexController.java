package caucasianYard.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String showIndex(){
        return "index";
    }



    public static class MyUI extends UI{

        @Override
        protected void init(VaadinRequest request) {

        }
    }





}
