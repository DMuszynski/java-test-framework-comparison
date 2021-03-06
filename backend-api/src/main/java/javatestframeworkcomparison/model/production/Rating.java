package javatestframeworkcomparison.model.production;

import com.sun.istack.NotNull;
import javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating extends AbstractEntity {

    @NotNull
    @Column(name = "count")
    private int count;

    @NotNull
    @Column(name = "average")
    private float average;

    public Rating() {}

    public Rating(int count, float average) {
        super();
        this.count = count;
        this.average = average;
    }

    public int getCount() {
        return count;
    }

    public float getAverage() {
        return average;
    }
}
