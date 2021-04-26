package pl.dmuszynski.javatestframeworkcomparison.model.user;

public enum AuthorityType {

    ROLE_USER("ROLE_USER");

    private String name;

    AuthorityType(String name) {
        this.name = name;
    }
}
