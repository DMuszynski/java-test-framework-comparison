package pl.dmuszynski.javatestframeworkcomparison.model.user;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.dmuszynski.javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User extends AbstractEntity implements UserDetails {

    @NotNull
    @Column(name = "email", unique = true, length = 35)
    private String email;

    @NotNull
    @Column(name = "username", unique = true, length = 20)
    private String username;

    @NotNull
    @Column(name = "password", length = 60)
    private String password;

    @NotNull
    @Column(name = "is_locked")
    private boolean isLocked;

    @NotNull
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "USER_AUTHORITY",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

    public static final class Builder {
        private Long id;
        private String email;
        private String username;
        private String password;
        private boolean isLocked;
        private boolean isEnabled;
        private Set<Authority> authorities;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder isLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        public Builder authorities(Set<Authority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public User build() {
//            if(email.isEmpty())
//                throw new IllegalStateException("Email cannot be empty");
//            if(username.isEmpty())
//                throw new IllegalStateException("Username cannot be empty");
//            if(password.isEmpty())
//                throw new IllegalStateException("Password cannot be empty");
//            if(authorities.isEmpty())
//                throw new IllegalStateException("Authorities cannot be empty");

            final User user = new User();
            user.id = id;
            user.email = email;
            user.username = username;
            user.password = password;
            user.isEnabled = isEnabled;
            user.isLocked = isLocked;
            user.authorities = authorities;

            return user;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
