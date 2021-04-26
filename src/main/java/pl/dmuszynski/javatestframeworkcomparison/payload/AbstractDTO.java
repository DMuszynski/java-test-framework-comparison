package pl.dmuszynski.javatestframeworkcomparison.payload;

import java.io.Serializable;

public class AbstractDTO implements Serializable {
    protected Long id;

    public AbstractDTO() {}

    public AbstractDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
