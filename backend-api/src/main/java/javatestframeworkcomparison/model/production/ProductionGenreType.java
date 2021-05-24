package javatestframeworkcomparison.model.production;

public enum ProductionGenreType {
    COMEDY("COMEDY"),
    DRAMA("DRAMA"),
    ACTION("ACTION");

    private String name;

    ProductionGenreType(String name) {
        this.name = name;
    }
}
