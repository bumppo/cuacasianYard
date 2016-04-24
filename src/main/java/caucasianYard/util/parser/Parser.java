package caucasianYard.util.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by forza on 24.04.2016.
 */
public class Parser {

    private static final String URL = "http://www.kavdvorik.ru/menu.php?file_menu=%d&section=1";

    public List<MenuMeal> getMenuMeals (int number) {
        Document doc = null;
        List<MenuMeal> meals = new ArrayList<>();

        try {
            doc = Jsoup.connect(String.format(URL, number)).
                    userAgent("Chrome/49.0.2623.112").
                    referrer("https://www.google.ru/").
                    timeout(7000).
                    get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (doc == null) return meals;

        Elements elements = doc.select("td[width=400");

        if (!elements.isEmpty()){
            for (Element element : elements) {
                Element parent = element.parent();
                MenuMeal menuMeal = new MenuMeal();

                menuMeal.setDescription(parent.select("div[id=ssilka]").first().text());
                String cost = parent.select("div[id=ssilka]").last().text();
                menuMeal.setCost(Integer.valueOf(cost.substring(0, cost.indexOf("-"))));

                meals.add(menuMeal);
            }
            return meals;
        } else {
            return meals;
        }
    }
}
