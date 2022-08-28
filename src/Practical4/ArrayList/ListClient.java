/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical4.ArrayList;

/**
 *
 * @author User
 */
public class ListClient {

    //create object for ADT List
    public static void main(String[] args) {
        ListInterface ls = new ArrayList();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(6);
        ls.add(7);
        ls.add(8);
        ls.add(9);
        ls.add(10);
        
        System.out.println(ls);
    }

}
