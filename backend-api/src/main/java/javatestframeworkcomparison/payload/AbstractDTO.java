package javatestframeworkcomparison.payload;

import java.io.Serializable;

public class AbstractDTO implements Serializable {

    protected Long id;

    public AbstractDTO() {
        this(0L);
    }

    public AbstractDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
