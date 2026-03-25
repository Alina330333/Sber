public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(Color color, double width, double height) {
        super(Kind.RECTANGLE, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Прямоугольник " + width + "x" + height + ", цвет: " + color);
    }
}
