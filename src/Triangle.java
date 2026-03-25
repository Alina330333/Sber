public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Color color, double sideA, double sideB, double sideC) {
        super(Kind.TRIANGLE, color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void draw() {
        System.out.println("Треугольник со сторонами " + sideA + ", " + sideB + ", " + sideC + ", цвет: " + color);
    }
}
