package model;

import javax.persistence.*;

/**
 * Created by VMoskalik on 16.02.2016.
 */

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity {

    @Id
    @SequenceGenerator(name = "global_seq_sg", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_sg")
    protected Integer id;

    public BaseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
