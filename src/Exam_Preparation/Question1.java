import java.util.Scanner;


public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter 1 digit: ");
        int digit = sc.nextInt();
        
        toBinary(digit);
        System.out.println("");
    }
    
    public static void toBinary(int digit) {
        if (digit == 0) {
            return;
        } 
            
        toBinary(digit/2);
        System.out.print(digit%2);
    }
}
