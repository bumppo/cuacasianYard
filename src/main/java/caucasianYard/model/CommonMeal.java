package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author Vitaly Moskalik
 *         created on 12.07.2016
 */
@Entity
@Table(name = "common_meal")
public class CommonMeal extends BaseEntity {

    @NotEmpty
    private String description;
    @NotEmpty
    private Integer cost;
    @NotNull
    private Set<User> users;

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "cost", nullable = false)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @ManyToMany(mappedBy = "commonMeals", fetch = FetchType.EAGER)
//    @JoinTable(name = "user_common_meal", joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "common_meal_fk"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
