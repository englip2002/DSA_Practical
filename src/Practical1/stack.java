/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical1;

import java.util.Stack;
import java.util.Iterator; //traverse

/**
 *
 * @author TARUC
 */
public class stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        // add item into stack (push) to back
        st.push(10);
        System.out.println(st);
        st.push(100);
        System.out.println(st);
        st.push(55);
        System.out.println(st);

        // remove an item (pop) LIFO- remove from back
        st.pop();
        System.out.println("After" + st);

        // traverse
        // Stack not able to to use for loop (peek)
        System.out.println(" -- version 1 -- ");
        for (int i = 0; i < st.size(); i++) {
            System.out.print(" " + st.peek());
        }

        System.out.println("\n -- version 2 -- ");
        for (int member : st){ // for each member inside list
            System.out.print(" " + member);
        }

        System.out.println("\n -- version 3 -- ");
        Iterator<Integer> iter = st.iterator();
        while (iter.hasNext()){// check value exist or not
            System.out.print(" " + iter.next());
        }

        // clear all thing in list
        st.clear();
        System.out.println("\n" + st);
        
    }
}
