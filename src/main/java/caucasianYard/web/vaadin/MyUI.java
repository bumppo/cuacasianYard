package caucasianYard.web.vaadin;

import caucasianYard.web.vaadin.utils.Utils;
import caucasianYard.web.vaadin.view.*;
import caucasianYard.web.vaadin.view.bill.BillView;
import caucasianYard.web.vaadin.view.menu.MenuView;
import caucasianYard.web.vaadin.view.order.OrderView;
import caucasianYard.web.vaadin.view.visitors.VisitorsView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Vitaly Moskalik
 *         created on 11.07.2016
 */
@Theme("mytheme")
@SuppressWarnings("serial")
public class MyUI extends UI {

    public MyUI() {
        Utils.addObjectToContext(this);
    }

    public class MainView extends VerticalLayout {
        private static final long serialVersionUID = -3398565663865641952L;

        Label title;
        HorizontalLayout content;
        CssLayout menu;
        Panel contentArea;
        Navigator navigator;

        class MenuButton extends Button {
            private static final long serialVersionUID = -8596942814960467072L;

            public MenuButton(String caption, String id) {
                super(caption);
                addStyleName(ValoTheme.MENU_ITEM);
//                setIcon(new ThemeResource("img/" + id + "-16px.png"));
                addClickListener(click -> navigator.navigateTo(id));
            }
        }

        public MainView() {
            setSizeFull();
            addStyleName(ValoTheme.MENU_ROOT);

            title = new Label("Кавказский дворик");
            title.addStyleName(ValoTheme.MENU_TITLE);
            addComponent(title);

            content = new HorizontalLayout();
            content.setSizeFull();
            content.setSpacing(true);
            content.setMargin(true);
            addComponent(content);
            setExpandRatio(content, 1.0f);

            menu = new CssLayout();
            menu.addStyleName(ValoTheme.MENU_PART);
            content.addComponent(menu);

            menu.addComponent(new MenuButton("Главная", "home"));
            menu.addComponent(new MenuButton("Меню",  "menu"));
            menu.addComponent(new MenuButton("Посетители", "visitors"));
            menu.addComponent(new MenuButton("Заказ", "order"));
            menu.addComponent(new MenuButton("Счёт", "bill"));

            contentArea = new Panel();
            contentArea.setSizeFull();
            contentArea.addStyleName(ValoTheme.PANEL_BORDERLESS);
            content.addComponent(contentArea);
            content.setExpandRatio(contentArea, 1.0f);

            // Create a navigator to control the sub-views
            navigator = new Navigator(UI.getCurrent(), contentArea);

            // Create and register the sub-views
            navigator.addView("home", HomeView.class);
            navigator.addView("menu", MenuView.class);
            navigator.addView("visitors", VisitorsView.class);
            navigator.addView("order", OrderView.class);
            navigator.addView("bill", BillView.class);
            navigator.setErrorView(HomeView.class);
        }
    }

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");
        // Enable Valo menu
        addStyleName(ValoTheme.UI_WITH_MENU);
        setResponsive(true);
        setContent(new MainView());
    }
}
