public class Circle extends Figure {
    private double radius;

    public Circle(Color color, double radius) {
        super(Kind.CIRCLE, color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Круг радиусом " + radius + ", цвет: " + color);
    }

    public double getRadius() {
        return radius;
    }
}
