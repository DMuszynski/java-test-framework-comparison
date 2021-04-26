package pl.dmuszynski.javatestframeworkcomparison.model.production;

import pl.dmuszynski.javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "IMAGE", schema = "SYS")
public class Image extends AbstractEntity {

}
