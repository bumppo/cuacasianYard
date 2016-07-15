package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by VMoskalik on 25.04.2016.
 */

@Entity
@Table(name = "menu")
public class Menu extends BaseMenuEntity {

    @NotEmpty
    private String name;
    private Set<MenuMeal> menuMeals;

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public Set<MenuMeal> getMenuMeals() {
        return menuMeals;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMenuMeals(Set<MenuMeal> menuMeals) {
        this.menuMeals = menuMeals;
    }
}
