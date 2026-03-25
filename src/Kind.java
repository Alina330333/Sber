public enum Kind {
    TRIANGLE("Треугольник"),
    CIRCLE("Круг"),
    RECTANGLE("Прямоугольник");

    private final String rusName;

    Kind(String rusName) {
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }

    @Override
    public String toString() {
        return rusName;
    }
}
