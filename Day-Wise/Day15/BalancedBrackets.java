import java.io.*;
import java.util.*;

public class BalancedBrackets {
    private static boolean handle(Stack<Character> st, char ch){
        if(st.size()==0){
            return false;
        }else if(st.peek() != ch)
        {
            return false;
        }else{
            st.pop();
            return true;
        }
        
    } 

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<str.length()){
            char ch = str.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                st.push(ch);
            }
            else if (ch == ']'){
                boolean result = handle(st, '[');
                if(result == false){
                    System.out.print(result);
                    return;
                }
            }
            else if (ch == ')'){
               boolean result = handle(st, '(');
                if(result == false){
                    System.out.print(result);
                    return;
                }
            }
            else if (ch == '}'){
                boolean result = handle(st, '{');
                if(result == false){
                    System.out.print(result);
                    return;
                }
            }
            i++;
        }
        System.out.print(st.empty());
        
    }

}