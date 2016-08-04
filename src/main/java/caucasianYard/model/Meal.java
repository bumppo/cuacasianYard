package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by VMoskalik on 16.02.2016.
 */

@Entity
@Table(name = "meal")
public class Meal extends BaseEntity {

    @NotEmpty
    private String description;
    @NotNull
    private Integer cost;
    @NotNull
    private User user;

    public Meal() {
    }
    public Meal(Integer id, String description, int cost){
        super(id);
        this.description = description;
        this.cost = cost;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    @Column(name = "cost", nullable = false)
    public Integer getCost() {
        return cost;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "description=" + description + ", " +
                "cost=" + cost +
                "}";
    }
}
