package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by VMoskalik on 25.04.2016.
 */

@Entity
@Table(name = "menu_meal")
public class MenuMeal extends BaseMenuEntity {

    @NotEmpty
    private String description;
    @NotNull
    private Integer cost;
    @NotNull
    private Menu menu;

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    @Column(name = "cost", nullable = false)
    public int getCost() {
        return cost;
    }

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    public Menu getMenu() {
        return menu;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
