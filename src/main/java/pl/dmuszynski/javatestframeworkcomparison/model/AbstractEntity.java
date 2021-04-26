package pl.dmuszynski.javatestframeworkcomparison.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public AbstractEntity() { this.id = 0L; }

    public AbstractEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
