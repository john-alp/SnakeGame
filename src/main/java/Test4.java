import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        boolean result = false;
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 1; i < size; ++i) {
            if (array[i] == array[i - 1]) {
                result = true;
            }
        }
        System.out.println(result);



    }
}