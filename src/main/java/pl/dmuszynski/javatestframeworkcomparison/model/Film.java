package pl.dmuszynski.javatestframeworkcomparison.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FILM", schema = "SYS")
public class Film extends Production {

}
