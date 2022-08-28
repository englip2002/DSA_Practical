/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical6;

public class P6Q3 {
    //fibonachi = the sum of 2 number before and start with 0 and 1
    // 0,1,1,2,3,5,8,13....
    
    //using recursive
    public int FiboRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (FiboRecursive(n - 1) + FiboRecursive(n - 2));
        }
    }

    public static void main(String[] args) {
        long startTime, endTime, time1 = 0;
        
        //using recursive
        startTime = System.nanoTime();
        for (int n = 0; n < 10; n++) {
            System.out.print(new P6Q3().FiboRecursive(n) + " ");
        }
        endTime = System.nanoTime();
        time1 = endTime - startTime;
        System.out.println("\n" + time1);
        
        //using loop
        startTime = System.nanoTime();
        int cur = 1;
        int prev = 0;
        System.out.print("0 1");
        for (int n = 2; n < 10; n++) {
            int temp = cur;
            cur = cur + prev;
            prev = temp;
            System.out.print(" " + cur);
        }
        endTime = System.nanoTime();
        time1 = endTime - startTime;
        System.out.println("\n" + time1);

    }

}
