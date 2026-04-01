import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Double> queue = new LinkedList<>();

        System.out.print("Введите количество элементов в очереди: ");
        int n = scanner.nextInt();

        System.out.println("Введите " + n + " вещественных чисел:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            queue.add(value);
        }

        System.out.println("\nСодержимое очереди:");
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            for (Double num : queue) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        if (!queue.isEmpty()) {
            double min = findMin(queue);
            System.out.println("Минимальный элемент: " + min);
        } else {
            System.out.println("Очередь пуста, невозможно найти минимум");
        }

        scanner.close();
    }

    public static double findMin(Queue<Double> queue) {
        double min = queue.peek();

        for (Double num : queue) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }
}