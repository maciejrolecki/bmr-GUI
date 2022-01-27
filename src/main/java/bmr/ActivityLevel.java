package bmr;

public enum ActivityLevel {
    ACTIVE("Actif",1.55),
    EXTREMELY_ACTIVE("Extrement actif",1.9),
    VERY_ACTIVE("Fort actif",1.725),
    NOT_VERY_ACTIVE("Peu actif",1.375),
    NOT_ACTIVE("Sedentaire",1.2);

    ActivityLevel(String name,double weight) {
        this.name = name;
        this.weight=weight;
    }
    private final String name;
    private final double weight;

    public String toString() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
