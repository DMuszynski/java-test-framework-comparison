package javatestframeworkcomparison.model.production;

import javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEW")
public class Review extends AbstractEntity {
    private String description;
    //private User user;
}
