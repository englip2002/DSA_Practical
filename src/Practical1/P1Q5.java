package Practical1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P1Q5 {
    public static void main(String[] args) {
        String palindromes = "A man, a plan, a canal: Panama!";
        System.out.println("The Stack check is " + checkWithStack(palindromes));
        System.out.println("The Queue check is " + checkWithQueue(palindromes));
        System.out.println("The Stack and Queue check is " + checkWithStackAndQueue(palindromes));
    }

    public static boolean checkWithStack(String palindromes) {
        Stack<Character> st = new Stack<>();
        palindromes = palindromes.toLowerCase();
        int stackSize;

        // to ignore the others character other than a to z
        for (int i = 0; i < palindromes.length(); i++) {
            // between a to z
            if (palindromes.charAt(i) >= 97 && palindromes.charAt(i) <= 122) {
                st.push(palindromes.charAt(i));
            }
        }
        // no need to specify is even or odd number because in computer 5/2=2 and
        // 4/2=2,the middle element will be ignored.

        // to get the updated stack size.
        stackSize = st.size();
        for (int i = 0; i < stackSize / 2; i++) {
            if (st.elementAt(i) != st.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWithQueue(String palindromes) {
        // queue is FIFO
        Queue<Character> queue = new LinkedList<>();
        List<Character> ls = new ArrayList<>();
        palindromes = palindromes.toLowerCase();
        int queueSize;

        // to ignore the others character other than a to z
        for (int i = 0; i < palindromes.length(); i++) {
            // between a to z
            if (palindromes.charAt(i) >= 97 && palindromes.charAt(i) <= 122) {
                queue.offer(palindromes.charAt(i));
                ls.add(palindromes.charAt(i));
            }
        }

        // to get the updated queue size
        queueSize = queue.size();
        for (int i = 0; i < queueSize / 2; i++) {
            // to get the element for comparision (-1 is cuz index out of bound if dont do)
            if (ls.get(queueSize - 1 - i) != queue.poll()) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkWithStackAndQueue(String palindromes) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        palindromes=palindromes.toLowerCase();

        // to ignore the others character other than a to z
        for (int i = 0; i < palindromes.length(); i++) {
            // between a to z
            if (Character.isLetterOrDigit(palindromes.charAt(i))) {
                queue.offer(palindromes.charAt(i));
                st.add(palindromes.charAt(i));
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            // to get the element for comparision (-1 is cuz index out of bound if dont do)
            System.out.println(st);
            System.out.println(queue);
            if (st.pop() != queue.poll()) {
                return false;
            }
        }

        return true;
    }
}
