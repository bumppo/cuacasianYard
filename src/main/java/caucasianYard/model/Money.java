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
    private Integer payed;
    @NotNull
    private Integer lucky;

    public Money() {
    }

    @Column(name = "payed_in_fact", nullable = false)
    public Integer getPayed() {
        return payed;
    }

    public void setPayed(Integer payed) {
        this.payed = payed;
    }

    @Column(name = "lucky_hours", nullable = false)
    public Integer getLucky() {
        return lucky;
    }

    public void setLucky(Integer lucky) {
        this.lucky = lucky;
    }
}
