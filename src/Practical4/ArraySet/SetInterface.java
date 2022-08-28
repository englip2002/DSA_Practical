/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical4.ArraySet;
//cannot have duplicate value - if add duplicate value, return false
//search by value not index

//ADT Set
//Title: Set Interface
//purpose : to Store values in set collection
public interface SetInterface<T> {

    public boolean add(T newElement);

    public boolean remove(T anElement);

    public boolean checkSubset(SetInterface anotherSet);

    public void union(SetInterface anotherSet);

    public SetInterface intersection(SetInterface anotherSet);

    public boolean isEmpty();
    
    public T[] getElement();

}
