package pl.dmuszynski.javatestframeworkcomparison.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTION", schema = "SYS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Production extends AbstractEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;
}
