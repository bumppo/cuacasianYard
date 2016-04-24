package caucasianYard.util.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by forza on 24.04.2016.
 */
public class HtmlView {

    private final String templatePath = "./src/main/java/" + this.getClass().getPackage().getName().replace(".", "/") + "/html/template.html";
    private final String filePath = "./src/main/java/" + this.getClass().getPackage().getName().replace(".", "/") + "/html/second_fish.html";

    private Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "utf-8");
    }

    private Document getTemplateDocument() throws IOException {
        return Jsoup.parse(new File(templatePath), "utf-8");
    }

    private String getUpdatedFileContent(List<MenuMeal> meals) {
        try {
            Document tempDoc = getTemplateDocument();
            Element template = tempDoc.select("tr[class=\"menu_meal\"]").first();

            Document doc = getDocument();
            doc.select("tr[class=\"menu_meal\"]").remove();


            for (MenuMeal menuMeal : meals) {
                Element mealElement = template.clone();
                mealElement.select("td[class=\"description\"]").first().text(menuMeal.getDescription());
                mealElement.select("td[class=\"cost\"]").first().text(String.valueOf(menuMeal.getCost()));
                doc.select("tr[class=\"menu_meal_template\"]").before(mealElement.outerHtml());
            }

            return doc.outerHtml();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void updatefile(String str) {
        try(Writer writer = new FileWriter(filePath)) {
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Parser parser = new Parser();
        view.updatefile(view.getUpdatedFileContent(parser.getMenuMeals(9)));
    }
}
