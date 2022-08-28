/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical5.QueueADT;

/**
 *
 * @author User
 */
public interface QueueInterface<T> {
    //add item
    public void enqueue (T newEntry);
    //remove item
    public T dequeue();
    //peek front item
    public T getFront();
    public boolean isEmpty();
    public void clear();
}
