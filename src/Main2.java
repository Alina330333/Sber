import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение в постфиксной записи:");
        String line = scanner.nextLine(); // Читаем всю строку

        scanner.close();

        // Разбиваем строку на токены по пробелам
        String[] tokens = line.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Это операция
                int b = stack.pop(); // второй операнд
                int a = stack.pop(); // первый операнд
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b; // целочисленное деление
                        break;
                }

                stack.push(result);
            } else {
                // Это число
                stack.push(Integer.parseInt(token));
            }
        }

        System.out.println("Результат: " + stack.pop());
    }
}