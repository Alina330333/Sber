import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String [] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 1;
        boolean b = false;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            stack.push(num);
            if (num % 2 != 0) {
                a *= num;
                b = true;
            }
        }
        if (b) {
            System.out.println(a);
        } else {
            System.out.println("Нечетных нет");
        }
        System.out.println(stack);
        scanner.close();
    }
}