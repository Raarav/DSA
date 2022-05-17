// Q->https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/postfix-evaluation-conversions-official/ojquestion#
// Time Complexity = O(n)
// Space Complexity = O(n)

import java.io.*;
import java.util.*;

public class PostfixEvalutionsAndConversions{
    private static int solve(int v1, int v2, char ch){
        if(ch == '+') return v1 + v2;
        else if(ch == '-') return v1 - v2;
        else if(ch == '*') return v1 * v2;
        else return v1 / v2;
    }
  private static boolean isChar(char ch){
      boolean flag = false;
      if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
          flag = true; 
      }
      return flag;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    
    // code
    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
    while(exp.length()!=0){
        char ch = exp.charAt(0);
        if(isChar(ch)){
            // evaluation
            if(value.empty()){
                value.push(Integer.parseInt(String.valueOf(ch)));
            }else{
                int v2 = value.pop();
                int v1 = value.pop();
                int ans = solve(v1,v2,ch);
                value.push(ans);
            }
            
            //conversions for infix 
            if(infix.empty()){
                infix.push(ch+"");
            }else{
                String strI2 = infix.pop();
                String strI1 = infix.pop();
                String ans = "(" + strI1 + ch + strI2 + ")";
                infix.push(ans);
            }
            
            //conversions for prefix
            if(prefix.empty()){
                prefix.push(ch+"");
            }else{
                String strP2 = prefix.pop();
                String strP1 = prefix.pop();
                String ans =  ch + strP1 + strP2;
                prefix.push(ans);
            }
            
            
        }else{
            value.push(Integer.parseInt(String.valueOf(ch)));
            infix.push(ch+"");
            prefix.push(ch+"");
        }
        exp = exp.substring(1);
    }
    
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
    
 }
}