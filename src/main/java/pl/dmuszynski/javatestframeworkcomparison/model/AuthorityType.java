package pl.dmuszynski.javatestframeworkcomparison.model;

public enum AuthorityType {

    ROLE_USER("ROLE_USER");

    private String name;

    AuthorityType(String name) {
        this.name = name;
    }
}
