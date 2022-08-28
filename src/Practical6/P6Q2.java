/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical6;

/**
 *
 * @author User
 */
public class P6Q2 {

    public void GCD(int a, int b) {
        if (a == 0) {
            System.out.println("GCD IS: " + b);
        } else if (b == 0) {
            System.out.println("GCD IS: " + a);
        } else {
            GCD(b, a % b);
        }
    }

    public static void main(String[] args) {
        new P6Q2().GCD(15, 30);
    }
}
