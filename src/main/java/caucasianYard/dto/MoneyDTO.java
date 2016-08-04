package caucasianYard.dto;

import caucasianYard.model.Money;

import javax.validation.constraints.NotNull;

/**
 * Created by VMoskalik on 21.03.2016.
 */
public class MoneyDTO {

    private Integer id;
    @NotNull
    private Integer payed;
    @NotNull
    private Integer lucky;
    private Integer sumWithOutDiscount;
    private Integer sumWithDiscount;
    private Integer tips;
    private float discount;

    public MoneyDTO(Money money) {
        this.id = money.getId();
        this.payed = money.getPayed();
        this.lucky = money.getLucky();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSumWithOutDiscount() {
        return sumWithOutDiscount;
    }
    public void setSumWithOutDiscount(Integer sumWithOutDiscount) {
        this.sumWithOutDiscount = sumWithOutDiscount;
    }

    public Integer getSumWithDiscount() {
        return sumWithDiscount;
    }
    public void setSumWithDiscount(Integer sumWithDiscount) {
        this.sumWithDiscount = sumWithDiscount;
    }

    public Integer getTips() {
        return tips;
    }
    public void setTips(Integer tips) {
        this.tips = tips;
    }

    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
