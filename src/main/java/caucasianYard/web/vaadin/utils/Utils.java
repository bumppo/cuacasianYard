package caucasianYard.web.vaadin.utils;


import com.vaadin.server.VaadinServlet;
import org.springframework.beans.BeansException;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Vitaly Moskalik
 *         created on 26.07.2016
 */
public class Utils {

    public static void addObjectToContext(Object object){
        //Add bean to Spring Context
        if (VaadinServlet.getCurrent() != null){
            try {
                WebApplicationContextUtils
                        .getRequiredWebApplicationContext(VaadinServlet.getCurrent().getServletContext())
                        .getAutowireCapableBeanFactory().autowireBean(object);
            } catch (BeansException e){
                e.printStackTrace();
            }
        }
    }
}
