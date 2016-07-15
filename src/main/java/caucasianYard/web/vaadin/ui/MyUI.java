package caucasianYard.web.vaadin.ui;

import caucasianYard.service.UserService;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.annotation.WebServlet;

/**
 * @author Vitaly Moskalik
 *         created on 11.07.2016
 */
@Theme("mytheme")
@SuppressWarnings("serial")
public class MyUI extends UI {

    @Autowired
    UserService userService;

    public MyUI() {
        //Add bean to Spring Context
        if (VaadinServlet.getCurrent() != null){
            try {
                WebApplicationContextUtils
                        .getRequiredWebApplicationContext(VaadinServlet.getCurrent().getServletContext())
                        .getAutowireCapableBeanFactory().autowireBean(this);
            } catch (BeansException e){
                e.printStackTrace();
            }
        }
    }

    @DesignRoot
    static public class AnimalView extends VerticalLayout implements View {
        private static final long serialVersionUID = 6852298665681141274L;

        Label watching;
        Embedded pic;
        Label back;

        public AnimalView() {
            Design.read(this);
        }

        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
            String animal = event.getViewName();

            watching.setValue("You are currently watching a " + animal);
//            pic.setSource(new ThemeResource("img/" + animal + "-128px.png"));
            back.setValue("and " + animal + " is watching you back");
        }
    }


    /** Main web with a menu (with declarative layout design) */
    @DesignRoot
    public class MainView extends HorizontalLayout {
        private static final long serialVersionUID = -3398565663865641952L;

        public static final String NAME = "main";

        Navigator navigator;

        class AnimalButton extends Button {
            private static final long serialVersionUID = -8596942814960467072L;

            public AnimalButton(String caption, String id) {
                super(caption);
                addStyleName(ValoTheme.MENU_ITEM);
//                setIcon(new ThemeResource("img/" + id + "-16px.png"));
                addClickListener(click -> navigator.navigateTo(id));
            }
        }

        Label title;
        CssLayout menu;
        Panel contentArea;
        Button logoutButton;

        public MainView(String username) {
            setSizeFull();
            addStyleName(ValoTheme.MENU_ROOT);

            title = new Label("Animal Farm");
            title.addStyleName(ValoTheme.MENU_TITLE);

            menu = new CssLayout();
            menu.addStyleName(ValoTheme.MENU_PART);
            addComponent(menu);

            menu.addComponent(new AnimalButton("Pig",      "pig"));
            menu.addComponent(new AnimalButton("Cat",      "cat"));
            menu.addComponent(new AnimalButton("Dog",      "dog"));
            menu.addComponent(new AnimalButton("Reindeer", "reindeer"));
            menu.addComponent(new AnimalButton("Penguin",  "penguin"));
            menu.addComponent(new AnimalButton("Sheep",    "sheep"));

            contentArea = new Panel("Equals");
            contentArea.addStyleName(ValoTheme.PANEL_BORDERLESS);
            contentArea.setSizeFull();
            addComponent(contentArea);
            setExpandRatio(contentArea, 1.0f);

            // Create a navigator to control the sub-views
            navigator = new Navigator(UI.getCurrent(), contentArea);

            // Create and register the sub-views
            navigator.addView("pig", AnimalView.class);
            navigator.addView("cat", AnimalView.class);
            navigator.addView("dog", AnimalView.class);
            navigator.addView("reindeer", AnimalView.class);
            navigator.addView("penguin",  AnimalView.class);
            navigator.addView("sheep",    AnimalView.class);
            navigator.addView("", AnimalView.class);

            // Allow going back to the start
//            logoutButton = new Button("Log Out");
//            logoutButton.addClickListener(click -> // Java 8
//                    logout.run());
//            addComponent(logoutButton);
        }

        /*
        @Override
        public void enter(ViewChangeEvent event) {
            if (event.getParameters() == null
                || event.getParameters().isEmpty()) {
                equalPanel.setContent(
                    new Label("Nothing to see here, " +
                              "just pass along."));
                return;
            } else
                equalPanel.setContent(new AnimalViewer(
                    event.getParameters()));
        }*/
    }

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");

        // Enable Valo menu
        addStyleName(ValoTheme.UI_WITH_MENU);
        setResponsive(true);

//        // Handle login and logout
//        setContent(new MainView(username, () -> {
//                    VaadinSession.getCurrent().close();
//                    Page.getCurrent().setLocation(VaadinServlet.getCurrent()
//                            .getServletContext().getContextPath() +
//                            "/navigator");
//                }));

        setContent(new MainView("username"));
    }







//    @Override
//    protected void init(VaadinRequest request) {
//        HorizontalLayout layout = new HorizontalLayout();
//        Grid users = new Grid();
//        Grid oneUser = new Grid();
//
//        users.setContainerDataSource(new BeanItemContainer<>(User.class, userService.getAll()));
//        users.setColumns("name");
//
//        BeanContainer<Integer, User> usersWithMeals = new BeanContainer<>(User.class);
//        usersWithMeals.setBeanIdProperty("id");
//        User user = userService.getWithMeals(100);
//        usersWithMeals.addBean(user);
////        Table table = new Table(user.getName(), usersWithMeals);
////        table.setVisibleColumns("name", );
//        oneUser.setContainerDataSource(new BeanItemContainer<>(Meal.class, user.getMeals()));
//        oneUser.setColumns("description", "cost");
//
////        oneUser.setContainerDataSource(new BeanContainer<>(User.class, userService.getWithMeals(100)));
//
//        layout.addComponent(users);
//        layout.addComponent(oneUser);
//        layout.setMargin(true);
//        layout.setSpacing(true);
//
//        setContent(layout);
//
////        setContent(new Label("Hello world!"));
//    }




}
