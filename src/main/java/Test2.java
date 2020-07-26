import java.util.Random;
import java.util.Scanner;

/**
 Вам даны три числа: a, b и n.

 Ваша задача-вывести сумму первых n случайных чисел в диапазоне от А до B включительно.
 Семя генератора должно быть установлено как a + b.

 Входные данные содержат числа в одной строке в следующем порядке: n, a, b.
 */
public class Test2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a  = scanner.nextInt();
        int b = scanner.nextInt();
        int result = 0;
        Random random = new Random(a + b);
        for (int i = 0; i < n; i++) {

            result += random.nextInt(b - a + 1);
        }
        System.out.println(result);




    }
}

/*

        int lower = scanner.nextInt();
        int upper = scanner.nextInt();
        Random random = new Random();

        int intervalLength = upper - lower + 1;

 */
