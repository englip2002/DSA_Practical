package Practical5.StackADT;

public interface StackInterface<T> {
    //add item
    public void push(T newEntry);
    
    //remove item
    public T pop();
    
    //get the top value without removing it
    public T peek();
    
    //is empty or not
    public boolean isEmpty();
    
    //clear the stack
    public void clear();
}
