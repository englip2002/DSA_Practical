/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical4.ArraySet;

//Implementer class for ADT SetInterface
public class ArraySet<T> implements SetInterface<T> {

    //class attribute
    private T[] array;
    private int numberOfEntries;

    //constructor
    public ArraySet() {
        numberOfEntries = 0;
        array = (T[]) new Object[5];
    }

    @Override
    public boolean add(T newElement) {
        //STEP1: check if array is full or not
        //if full, class increaseArraySize();

        //STEP2: check uf newElement is part of array
        for (T member : array) {
            if (member == newElement) {
                return false;  //alrd exist in set
            }
        }
        //STEP3: add newElement to array
        array[numberOfEntries] = newElement;
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean remove(T anElement) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (array[i] == anElement) { //check if element exists
                for (int j = i; j < numberOfEntries - 1; j++) { //loop to move the element 1 place front
                    array[j] = array[j + 1];
                }

                //remove last entires
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkSubset(SetInterface anotherSet) {
        boolean isSubset;

        //check every element
        for (T item1 : (T[]) anotherSet.getElement()) {
            isSubset = false;
            for (T item2 : array) {
                if (item1 == item2) {
                    isSubset = true;
                }
            }
            if (isSubset == false) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void union(SetInterface anotherSet) {
        //no need validation since validation done in add()
        for (T item : (T[]) anotherSet.getElement()) {
            this.add(item);
        }
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        SetInterface intersactionSet = new ArraySet<T>();
        //find the same element
        for (T item1 : (T[]) anotherSet.getElement()) {
            for (T item2 : array) {
                if (item1 == item2) 
                    intersactionSet.add(item1);
            }
        }
        return intersactionSet;
    }
    
    @Override
    public boolean isEmpty(){
        if(numberOfEntries==0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < numberOfEntries; i++) {
            out += array[i] + " ";
        }
        out += "\n";
        return out;
    }

    @Override
    public T[] getElement() {
        return array;
    }
}
