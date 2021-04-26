package pl.dmuszynski.javatestframeworkcomparison.model.production;

import pl.dmuszynski.javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEW", schema = "SYS")
public class Review extends AbstractEntity {
    private String description;
    //private User user;
}
