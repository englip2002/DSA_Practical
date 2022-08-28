package Practical3.P3Q1;

import java.time.chrono.ThaiBuddhistEra;

/**
 *
 * @author Eng Lip
 */
public class P3Q1 {

    public static long algorithmA(int n) {
        long startTime = System.nanoTime();
        int sum = 0;
        int i;
        for (i = 0; i < n; i++) {
            sum = sum + i;
        }
        return System.nanoTime() - startTime;
    }

    public static long algorithmB(int n) {
        long startTime = System.nanoTime();
        int sum = 0;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < 1; j++) {
                sum = sum + 1;
            }
        }
        return System.nanoTime() - startTime;
    }

    public static long algorithmC(int n) {
        long startTime = System.nanoTime();
        int sum = 0;
        sum = n * (n + 1) / 2;
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("+====================================================+");
        System.out.println("|No  |AlgorithmA     |AlgorithmB     |AlgorithmC     |");
        System.out.println("+====================================================+");
        for (int i = 0; i < 10; i++) {
            System.out.print(String.format("|%2dms|%13sms|%13sms|%13sms|\n", i+1,algorithmA(n),algorithmB(n),algorithmC(n)));
        }
        System.out.println("+====================================================+");
    }
}
