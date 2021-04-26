package pl.dmuszynski.javatestframeworkcomparison.model.production;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FILM", schema = "SYS")
public class Film extends Production {

    public Film() {}
}
