package Practical1;

import java.util.Stack;

public class P1Q4 {
    public static void main(String[] args) {
        String postfix = "562+53*/-";
        rearranger(postfix);
    }

    public static void rearranger(String postfix) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            if (postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*'
                    || postfix.charAt(i) == '/') {
                String firstPop = st.pop();
                String secondPop = st.pop();
                
                if(i==postfix.length()-1){
                    st.push(secondPop + " " + postfix.charAt(i) + " " + firstPop);
                }
                else{
                    st.push("( " + secondPop + " " + postfix.charAt(i) + " " + firstPop + " )");
                }
                
            } else {
                st.push(Character.toString(postfix.charAt(i)));
            }
        }

        // display
        for (String member : st) { // for each member inside list
            System.out.print(" " + member);
        }
    }
}
