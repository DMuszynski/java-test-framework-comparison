package pl.dmuszynski.javatestframeworkcomparison.model;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHORITY", schema = "SYS")
public class Authority extends AbstractEntity implements GrantedAuthority {

    @NotNull
    @Column(name = "authority_type", unique = true, length = 15)
    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Authority() {}

    public Authority(Long id, AuthorityType authorityType) {
        super(id);
        this.authorityType = authorityType;
    }

    @Override
    public String getAuthority() {
        return authorityType.name();
    }
}
