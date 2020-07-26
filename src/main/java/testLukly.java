import java.lang.reflect.Array;
import java.util.Scanner;

public class testLukly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0, midNumber = 0, previousNumber = 0;
        boolean flag = false;
        while(true){
            System.out.print("Enter a number: ");
            currentNumber = scanner.nextInt();
            if(currentNumber == 0 && midNumber != 0){
                break;
            }
            if(previousNumber != 0 && midNumber != 0){
                flag = false;
                if(
                        (previousNumber <= midNumber && midNumber <= currentNumber)
                                ||
                                (previousNumber >= midNumber && midNumber >= currentNumber)
                ){
                    flag = true;
                }
            }
            previousNumber = midNumber;
            midNumber = currentNumber;
        }
        scanner.close();
        System.out.println(flag);
    }
}



        //            Scanner scanner = new Scanner(System.in);
//            int m = scanner.nextInt();
//            int p = scanner.nextInt();
//            int k = scanner.nextInt();
//            int result = k;
//            int temp = m;
//            scanner.close();
//            while (result >= k){
//              result = temp + ( m * p / 100);
//    }
//        System.out.println(result);
