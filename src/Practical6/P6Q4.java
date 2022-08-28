/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical6;

public class P6Q4 {

    public void displayBackward(int[] arr, int arrLen) {
        System.out.println(arr[arrLen - 1]);
        if (arrLen > 1) {
            displayBackward(arr, arrLen - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        new P6Q4().displayBackward(arr, arr.length);
    }
}
