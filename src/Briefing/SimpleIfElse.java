/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Briefing;

import java.util.Scanner;

/**
 *
 * @author TARUC
 */
public class SimpleIfElse {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1;
        int num2;
        System.out.print("Enter First Number:");
        num1 = scan.nextInt();
        System.out.print("Enter Second Number:");
        num2 = scan.nextInt();
        System.out.println();

        if (num1 == num2) {
            System.out.println(num1 + " and " + num2 + " is same ");
        } else if (num1 < num2) {
            System.out.println(num2 + " is bigger than " + num1);
        } else {
            System.out.println(num1 + " is bigger than " + num2);
        }

        scan.close();
    }
}
