package pl.dmuszynski.javatestframeworkcomparison.model.production;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FILM")
public class Film extends Production {

    public Film() {}
}
