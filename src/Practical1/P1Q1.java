/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TARUC
 */
public class P1Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> scores = new ArrayList<Integer>();
        int newScore = 0;

        while (newScore != -1) {
            System.out.print("Enter score:");
            newScore = scanner.nextInt();

            if (newScore > 100 && newScore != -1) {
                System.out.println("Invalid Marks!!");
            } else if (newScore >= 0 && newScore <= 100) {
                scores.add(newScore);
            }
        }
        System.out.println("The lowest score is " + getSmallest(scores));
        System.out.println("The biggest score is " + getBiggest(scores));
        System.out.println("The average score is " + getAverage(scores));
        scanner.close();
    }

    public static int getSmallest(List<Integer> scores) {
        Integer smallestNum = scores.get(0);
        int i;
        for (i = 1; i < scores.size(); i++) {
            if (scores.get(i) < smallestNum) {
                smallestNum = scores.get(i);
            }
        }
        return smallestNum;
    }

    public static Integer getBiggest(List<Integer> scores) {
        Integer biggestNum = scores.get(0);
        int i;
        for (i = 1; i < scores.size(); i++) {
            if (scores.get(i) > biggestNum) {
                biggestNum = scores.get(i);
            }
        }
        return biggestNum;
    }

    public static double getAverage(List<Integer> scores) {
        int total = 0;
        double average;
        int i;
        for (i = 0; i < scores.size(); i++) {
            total = total + scores.get(i);
        }
        average = (double) (total / scores.size());
        return average;
    }
}
