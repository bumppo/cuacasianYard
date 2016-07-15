package caucasianYard.to;

import caucasianYard.model.Money;

/**
 * Created by VMoskalik on 21.03.2016.
 */
public class TOMoney extends Money {

    private Integer sumWithOutDiscount;
    private Integer sumWithDiscount;
    private Integer tips;
    private float discount;

    public TOMoney() {
    }
    public TOMoney(Integer id, Integer payed, Integer lucky) {
        super(id, payed, lucky);
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
