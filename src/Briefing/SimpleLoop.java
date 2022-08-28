/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Briefing;

import java.util.Scanner;

/**
 *
 * @author EngLip
 */
public class SimpleLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j,k;
        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        //int col = row;

        //need j<=i is because it needs to print a "*" when i = 0
        for (i = 0; i < row; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        

        System.out.println();
        
        for (i = 0; i < row; i++) {
            for (j = 0; j < row-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println();
        
        //i need to start from 1 because if row-i (5-0) it will produce a extra space 
        for (i = 1; i <= row; i++) {
            for (j = 0; j < row-i; j++) {
                System.out.print(" ");
            }
            for (k = 0; k < i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println();
        
        for (i = 0; i < row; i++) {
            for (k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (j = 0; j < row-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
