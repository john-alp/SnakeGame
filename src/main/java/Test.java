public class Test {
    private int[] xx = new int[400]; // максимальный размер змейки
    private int[] yy = new int[400];

    public static void main (String[] args) {
        Test test = new Test();
        test.testing();
    }
    private void testing(){
    for (int i = 3; i > 0 ; i--) {
        xx[i] = xx[i - 1];
        yy[i] = yy[i - 1];
        System.out.println(xx[i] + " " + yy[i]);
    }

    }
}
