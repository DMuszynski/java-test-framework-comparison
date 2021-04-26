package pl.dmuszynski.javatestframeworkcomparison.model.user;

import com.sun.istack.NotNull;
import pl.dmuszynski.javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "TOKEN", schema = "SYS")
public class Token extends AbstractEntity {

    @NotNull
    @Column(name = "value", unique = true, length = 40)
    private String value;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Token() {}

    public Token(String value, User user) {
        super();
        this.user = user;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }
}
