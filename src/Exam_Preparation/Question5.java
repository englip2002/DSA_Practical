
import java.util.Scanner;


public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter digit 1: ");
        int digit1 = sc.nextInt();
        System.out.print("Please enter digit 2: ");
        int digit2 = sc.nextInt();
        
        System.out.println(power(digit1, digit2));
    }
    
    public static int power(int digit1, int digit2) {

        if (digit2 == 1) {
            return digit1;
        } 
        else {
            return digit1 * power(digit1, digit2 - 1);
        }
    }
}
