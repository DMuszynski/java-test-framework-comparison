package pl.dmuszynski.javatestframeworkcomparison.model.production;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SERIES", schema = "SYS")
public class Series extends Production {

}
