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
public class SimpleCalculation {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Convert Farenheit to Celcius");
            System.out.println("2.Convert Celcius to Farenheit");
            System.out.print("Enter Your Choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                System.out.print("Enter the Farenheit:");
                double farenheit = scan.nextDouble();
                double celcius = (farenheit - 32) * 5.0 / 9.0;
                System.out.println("Celcius is " + celcius);
            } else if (choice == 2) {
                System.out.print("Enter the Celcius:");
                double celcius = scan.nextDouble();
                double farenheit = (celcius / (5.0 / 9.0)) + 32;
                System.out.println("Farenheit is " + farenheit);
            } else {
                System.out.println("invalid choice");
            }
        } while (choice !=1 && choice !=2);

        scan.close();
    }
}
