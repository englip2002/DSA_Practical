package Practical5.StackADT;

import java.util.Iterator;

public class LinkedStack<T> implements StackInterface<T>, Iterator<T> {

    //attribute
    Node top;
    Node iterNext;

    //constructor - set new stack as empty
    public LinkedStack() {
        top = null;
        iterNext=top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        return top.data;
    }

    public void clear() {
        top = null;
    }

    public void push(T newEntry) {
        //STEP1: create new node;
        
        //although it is first entry, still can use this beacause top will be null
        //top is previous node's address
        Node newNode = new Node(newEntry, top);
        
        //top is updated
        top = newNode;
    }
    
    public T pop(){
        if(!isEmpty()){
            //point temp node to top
            Node temp = top;
            //point top to next(previous) node
            top = top.next;
            return temp.data;
        }
        else{
            return (T)"NO POP. STACK IS EMPTY";
        }
    }
    
    //iterator interface
    public boolean hasNext(){
        //return true if collection still has next member
        //return false if not
        return iterNext.next!=null;
    }
    
    public T next(){
        Node temp;
        //return current member of collection
        if(hasNext()){
            temp = iterNext;
            iterNext=iterNext.next;
            return temp.data;
        }
        else{
            return (T)"Done";
        }
    }

    //inner class (supporting class)
    private class Node {

        private T data;
        private Node next; //memory address of next node

        //constructor
        public Node(T newEntry) {
            data = newEntry; //value to keep
            next = null;  //??
        }

        public Node(T newEntry, Node previousNode) {
            data = newEntry; //value to keep
            next = previousNode;
        }
    }
}
