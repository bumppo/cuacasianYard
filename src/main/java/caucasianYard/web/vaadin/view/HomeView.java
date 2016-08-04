package caucasianYard.web.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Random;

/**
 * @author Vitaly Moskalik
 *         created on 15.07.2016
 */
public class HomeView extends VerticalLayout implements View {

    private Label welcome = new Label();
    private Embedded picture = new Embedded();

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setSpacing(true);
        setMargin(true);

        picture.setSource(new ThemeResource("img/pict-" + randInt(1, 4) + ".jpg"));

        welcome.setValue("Добро пожаловать!");
        welcome.addStyleName(ValoTheme.LABEL_HUGE);

        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addComponents(picture, welcome);
    }

    /**
     * Random int generator in bound, inclusive.
     *
     * @param min min value.
     * @param max max value.
     * @return Integer between min and max, inclusive.
     */
    private static int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
