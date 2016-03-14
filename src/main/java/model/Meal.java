package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by VMoskalik on 16.02.2016.
 */

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "cost", nullable = false)
    private Integer cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Meal() {
    }

//    public Integer getCost() {
//        return cost;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setCost(Integer cost) {
//        this.cost = cost;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return this.description + "_" + this.cost;
    }
}
