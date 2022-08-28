/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical4.ArraySet;

/**
 *
 * @author User
 */
public class SetClient {

    public static void main(String[] args) {
        //create object SET
        SetInterface<Integer> set1 = new ArraySet();

        set1.add(1);
        set1.add(1);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println(set1);

        set1.remove(1);
        System.out.println(set1);

        SetInterface<Integer> set2 = new ArraySet();
        set2.add(2);
        set2.add(3);
        
        //check subset
        System.out.println(set1.checkSubset(set2));
        
        //intersection
        System.out.println(set1.intersection(set2));
        
        //union
        set2.add(4);
        set1.union(set2);
        System.out.println(set1);
    }
}
