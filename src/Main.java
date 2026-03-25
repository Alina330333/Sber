public class Main {
    public static void main(String[] args) {
        // Создаем массив фигур
        Figure[] figures = new Figure[3];

        figures[0] = new Circle(Color.RED, 5.0);
        figures[1] = new Rectangle(Color.BLUE, 4.0, 6.0);
        figures[2] = new Triangle(Color.GREEN, 3.0, 4.0, 5.0);

        // Выводим информацию о каждой фигуре
        System.out.println("=== Информация о фигурах ===\n");

        for (Figure fig : figures) {
            fig.draw();
            System.out.println("  Тип: " + fig.getKind());
            System.out.println("  Площадь: " + fig.getArea());
            System.out.println("  Периметр: " + fig.getPerimeter());
            System.out.println();
        }

        // Дополнительно: работа с конкретным типом фигуры
        System.out.println("=== Работа с конкретным кругом ===");
        Circle circle = new Circle(Color.YELLOW, 3.0);
        circle.draw();
        System.out.println("Радиус: " + circle.getRadius());
        System.out.println("Площадь: " + circle.getArea());
    }
}