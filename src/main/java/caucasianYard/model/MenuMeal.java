package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by VMoskalik on 25.04.2016.
 */

@Entity
@Table(name = "menu_meal")
public class MenuMeal extends BaseMenuEntity {

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "cost", nullable = false)
    private int cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    public String getDescription() {
        return description;
    }
    public int getCost() {
        return cost;
    }
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
