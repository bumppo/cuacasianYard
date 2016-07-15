package caucasianYard.web.vaadin.servlet;

import caucasianYard.web.vaadin.ui.MyUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author Vitaly Moskalik
 *         created on 15.07.2016
 */
@WebServlet(urlPatterns = {"/vui/*", "/VAADIN/*"}, name = "MyVaadinServlet")
@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
public class MyVaadinServlet extends VaadinServlet {

}
