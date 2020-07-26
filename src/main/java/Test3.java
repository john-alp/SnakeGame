import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parts = {0, 0, 0};
        final int temp = scanner.nextInt();

        for (int i = 0; i < temp; i++) {
            try {
                ++parts[scanner.nextInt()];
            } catch (Exception e) {
                ++parts[2];
            }
        }
        System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
    }
}
