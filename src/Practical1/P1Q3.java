package Practical1;

import java.util.Stack;

public class P1Q3 {
    public static void main(String[] args) {
        String expression = "(6+2)/(5*3)";
        System.out.println(validateBracket(expression));

    }

    public static boolean validateBracket(String expression) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '(') {
                st.push(expression.charAt(i));
            } 
            else if (expression.charAt(i) == '}') {
                if (st.empty() == true) {
                    return false;
                } else if (st.peek() != '{') { 
                    return false;
                } else {
                    st.pop();
                }
            }
            else if(expression.charAt(i) == ']'){
                if (st.empty() == true) {
                    return false;
                } else if (st.peek() != '[') { 
                    return false;
                } else {
                    st.pop();
                }
            }
            else if(expression.charAt(i) == ')'){
                if (st.empty() == true) {
                    return false;
                } else if (st.peek() != '(') { 
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        if(st.empty()==true){
            return true;
        }
        else{
            return false;
        }
        
    }
}
