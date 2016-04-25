package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by VMoskalik on 25.04.2016.
 */

@Entity
@Table(name = "menu")
public class Menu extends BaseMenuEntity {

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "menu")
    private List<MenuMeal> menuMeals;

    public String getName() {
        return name;
    }
    public List<MenuMeal> getMenuMeals() {
        return menuMeals;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMenuMeals(List<MenuMeal> menuMeals) {
        this.menuMeals = menuMeals;
    }
}
