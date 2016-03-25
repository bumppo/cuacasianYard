package caucasianYard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by VMoskalik on 21.03.2016.
 */
@Entity
@Table(name = "money")
public class Money extends BaseEntity{

    @NotNull
    @Column(name = "payed_in_fact", nullable = false)
    protected Integer payed;

    @NotNull
    @Column(name = "lucky_hours", nullable = false)
    protected Integer lucky;

    public Money() {
    }

    public Money(Integer id, Integer payed, Integer lucky) {
        super(id);
        this.payed = payed;
        this.lucky = lucky;
    }

    public Integer getPayed() {
        return payed;
    }

    public void setPayed(Integer payed) {
        this.payed = payed;
    }

    public Integer getLucky() {
        return lucky;
    }

    public void setLucky(Integer lucky) {
        this.lucky = lucky;
    }
}
