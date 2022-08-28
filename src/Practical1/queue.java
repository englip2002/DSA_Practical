/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical1;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
/**
 *
 * @author TARUC
 */
public class queue {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        
        //add item into queue (offer) to back
        que.offer(10);
        System.out.println(que);
        que.offer(100);
        System.out.println(que);
        que.offer(55);
        System.out.println(que);
        que.offer(44);
        System.out.println(que);
        
        //queue cannot add value by index
        
        //remove an item (poll) FIFO- remove from front
        que.poll(); 
        System.out.println("After"+que);
        que.poll();
        System.out.println("After"+que);
        
        
        //traverse 
        //Queue cannot use for loop (peek)
       System.out.println(" -- version 1 -- ");
       for(int i=0;i<que.size();i++){
            System.out.println(" "+que.peek());
       }

       System.out.println("--version 2--");
       //for each loop
       for(int member : que){
           System.out.println(" "+member);
       }
        
       System.out.println("--version 3--");
       //it will use the hasnext to check the next is exist or not, if yes, then use next to extract value
       Iterator<Integer> iter = que.iterator();
       while(iter.hasNext()){
            System.out.println(" "+iter.next());
       }
       
       //clear all thing in list
       que.clear(); 
       System.out.println(que);
    }
}
