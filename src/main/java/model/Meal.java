package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by VMoskalik on 16.02.2016.
 */

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "cost", nullable = false)
    private Integer cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //for :select form in JSP
    @Transient
//    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    public Meal() {
//        this.user_id = this.user.getId();
    }

    public Meal(Integer id, String description, int cost){
        super(id);
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCost() {
        return cost;
    }

    public User getUser() {
        return user;
    }

    public Integer getUser_id() {
        return user_id;
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

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return this.description + "_" + this.cost;
    }
}
