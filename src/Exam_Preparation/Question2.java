
import java.util.Scanner;


public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter # of rabbits: ");
        int rabbits = sc.nextInt();
        
        
        System.out.println(countEars(rabbits) + " ears");
    }
    
    public static int countEars(int rabbits){
        if(rabbits == 1){
            return 2;
        }
        else{
            return 2 + countEars(rabbits - 1);
        }
    }
}
