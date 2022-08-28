/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical6;

public class P6Q1 {

    public void countUp(int n) {
        if (n > 1) {
            countUp(n - 1);
        }
        System.out.println(n);

    }
    
    public static void main(String[] args) {
         int i = 5;
         new P6Q1().countUp(i);
    }
}
