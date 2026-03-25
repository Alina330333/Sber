public abstract class Figure {
    protected Kind kind;
    protected Color color;

    public Figure(Kind kind, Color color) {
        this.kind = kind;
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public void draw() {
        System.out.println("Рисуем " + kind + " цвета " + color);
    }

    public Kind getKind() {
        return kind;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
