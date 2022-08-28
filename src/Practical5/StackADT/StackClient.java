package Practical5.StackADT;

public class StackClient  {
    public static void main(String[] args) {
        StackInterface st = new LinkedStack(); //top --> null
        
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        
//        System.out.println("Peek: "+st.peek());
//        System.out.println("Pop: "+st.pop());
//        System.out.println("Pop: "+st.pop());
//        System.out.println("Pop: "+st.pop());
//        System.out.println("Pop: "+st.pop());
//        System.out.println("Pop: "+st.pop());
        
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
