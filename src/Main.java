import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();

        System.out.println("Введите числа: ");

        double num;
        while ((num = scanner.nextDouble()) != 0) {
            stack.push(num);
        }

        double max = stack.get(0);
        for (int i = 1; i < stack.size(); i++) {
            if (stack.get(i) > max) {
                max = stack.get(i);
            }
        }

        System.out.println("Стек: " + stack);
        System.out.println("Максимум: " + max);

        scanner.close();
    }
}