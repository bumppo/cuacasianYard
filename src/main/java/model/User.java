package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

/**
 * Created by VMoskalik on 16.02.2016.
 */

@Entity
@Table(name = "users")
//@Proxy(lazy=false)
public class User extends BaseEntity {

    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String name;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy("cost DESC")
    protected List<Meal> meals;

    public User() {
    }

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}