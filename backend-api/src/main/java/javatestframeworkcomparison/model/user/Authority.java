package javatestframeworkcomparison.model.user;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHORITY")
public class Authority extends AbstractEntity implements GrantedAuthority {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "authority_type", unique = true, length = 15)
    private AuthorityType authorityType;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Authority() {}

    public Authority(AuthorityType authorityType) {
        super();
        this.authorityType = authorityType;
    }

    @Override
    public String getAuthority() {
        return authorityType.name();
    }
}
