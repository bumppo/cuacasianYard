package caucasianYard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;


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

    public User(Integer id, String name){
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + ", " +
                "name=" + name +
                "}";
    }
}
