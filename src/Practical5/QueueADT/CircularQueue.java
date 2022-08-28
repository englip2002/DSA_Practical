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
public class CircularQueue<T> implements QueueInterface<T> {

    //attribute
    Node lastNode;

    //constructor
    public CircularQueue() {
        lastNode = null;
    }

    public boolean isEmpty() {
        return lastNode == null;
    }

    //new data
    public void enqueue(T newEntry) {
        //STEP1: independent node - point to null
        Node newNode = new Node(newEntry, null);

        if (isEmpty()) { //add 1st node to empty queue
            //1st node point to itself
            newNode.next = newNode;
        } else {
            //point new node to 1st node
            newNode.next = lastNode.next;
            //point old last node to new node
            lastNode.next = newNode;
        }
        //copy new node to last node
        lastNode = newNode;
    }

    //remove item
    public T dequeue() {
        //Create temporary T
        T front;
        if (lastNode.next == lastNode) { //only 1 item
            front = lastNode.data;
            lastNode = null;
        } else {
            //go to first node and get data
            front = lastNode.next.data;
            //point last node to next node
            lastNode.next = lastNode.next.next;
        }
        return front;
    }

    //peek front item
    public T getFront() {
        if (isEmpty()) {
            return (T) "No front item";
        } else {
            //lastnode.next = front node
            return lastNode.next.data;
        }
    }

    public void clear() {
        lastNode = null;
    }

    //inner class
    private class Node {

        private T data;
        private Node next;

        public Node(T newEntry, Node nextNode) {
            data = newEntry; //value to keep
            next = nextNode; //address of next member
        }
    }
}
