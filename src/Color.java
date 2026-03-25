public enum Color {
    RED("красный"),
    BLUE("синий"),
    GREEN("зеленый"),
    YELLOW("желтый"),
    BLACK("черный"),
    WHITE("белый");

    private final String rusName;

    Color(String rusName) {
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
