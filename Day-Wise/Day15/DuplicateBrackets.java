import java.io.*;
import java.util.*;

public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        int i = 0;
        boolean result = false;
        while(i<str.length()){
            char ch = str.charAt(i);
            if(ch == ')'){
                if(st.peek()=='('){
                    result = true;
                    break;
                }else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
            i++;
        }
        System.out.print(result);
    }

}