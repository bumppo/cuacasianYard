package caucasianYard.model;

import javax.persistence.*;

/**
 * Created by VMoskalik on 16.02.2016.
 */

@MappedSuperclass
//@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class BaseEntity {

    protected Integer id;

    public BaseEntity() {
    }
    public BaseEntity(Integer id) {
        this.id = id;
    }

    @Id
    @SequenceGenerator(name = "global_seq_sg", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_sg")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
