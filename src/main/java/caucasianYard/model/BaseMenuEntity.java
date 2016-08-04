package caucasianYard.model;

import javax.persistence.*;

/**
 * Created by VMoskalik on 25.04.2016.
 */

@MappedSuperclass
public abstract class BaseMenuEntity {

    private int id;

    @Id
    @SequenceGenerator(name = "menu_seq_sg", sequenceName = "menu_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq_sg")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
