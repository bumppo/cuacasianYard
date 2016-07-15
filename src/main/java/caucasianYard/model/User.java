package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
//@Proxy(lazy=false)
public class User extends BaseEntity {

    @NotEmpty
    private String name;
    private Set<Meal> meals;
    private Set<CommonMeal> commonMeals;

    public User() {
    }
    public User(Integer id, String name){
        super(id);
        this.name = name;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    @OrderBy("cost DESC")
    public Set<Meal> getMeals() {
        return meals;
    }

    @ManyToMany
    @JoinTable(name = "user_common_meal", joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "common_meal_fk"))
    public Set<CommonMeal> getCommonMeals() {
        return commonMeals;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }
    public void setCommonMeals(Set<CommonMeal> commonMeals) {
        this.commonMeals = commonMeals;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + ", " +
                "name=" + name +
                "}";
    }
}
