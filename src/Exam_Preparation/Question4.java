
import java.util.Scanner;

// 3 * 2 --- 3 + 3
// 2 * 3 --- 2 + 2 +2

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter digit 1: ");
        int digit1 = sc.nextInt();
        System.out.print("Please enter digit 2: ");
        int digit2 = sc.nextInt();
        
        System.out.println(multiply(digit1, digit2));
    }
    
    public static int multiply(int digit1, int digit2){
        if(digit2 == 0){
            return 0;
        }
        else{
            return digit1 + multiply(digit1, digit2-1);
        }
    }
}
