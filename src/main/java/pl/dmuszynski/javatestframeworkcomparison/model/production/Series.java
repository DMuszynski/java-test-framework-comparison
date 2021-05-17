package pl.dmuszynski.javatestframeworkcomparison.model.production;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SERIES")
public class Series extends Production {

    public Series() {}
}
