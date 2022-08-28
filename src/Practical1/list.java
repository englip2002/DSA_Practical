/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical1;
//import ADT
import java.util.List;

//import implementer
import java.util.ArrayList;
import java.util.Iterator; //traverse
/**
 *
 * @author TARUC
 */
public class list {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create List
        List<Integer> ls = new ArrayList<>();
        
        //add item
        ls.add(10);
        System.out.println(ls);
        ls.add(100);
        System.out.println(ls);
        ls.add(55);
        System.out.println(ls);
        ls.add(1,99);  //add 99 at index 1
        System.out.println(ls);
        
        
        //remove
        ls.remove(0); //remove an item
        System.out.println("After"+ls);
        ls.remove(ls.get(1)); 
        System.out.println("After"+ls);
        
        
       //traverse
       System.out.println("--version 1--");
       for(int i=0;i<ls.size();i++){
           System.out.println(" "+ls.get(i));
       }
       
       System.out.println("--version 2--");
       //for each loop
       for(int member : ls){
           System.out.println(" "+member);
       }
        
       System.out.println("--version 3--");
       //it will use the hasnext to check the next is exist or not, if yes, then use next to extract value
       Iterator<Integer> iter = ls.iterator();
       while(iter.hasNext()){
            System.out.println(" "+iter.next());
       }
       
       //clear all thing in list
       ls.clear(); 
       System.out.println(ls);
    }
    
}
