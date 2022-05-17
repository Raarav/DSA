// https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-encodings-official/ojquestion#

// Q->Print Encodings

import java.io.*;
import java.util.*;

public class print_encodings {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str,"");
    }

    public static void printEncodings(String str,String result) {
        
        if(str.length() == 0){
            System.out.println(result);
            return;
        }
        
        if(str.length()==1){
            char ch = str.charAt(0);
            if(ch == '0'){
                return;
            }else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                System.out.println(result + code);
            }
        }else {
            char ch = str.charAt(0);
            String ros = str.substring(1);
            if(ch == '0'){
                return;
            }else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncodings(ros,result+code);
            }
            
            int val = Integer.parseInt(str.substring(0,2));
            ros = str.substring(2);
            if(val <= 26){
                char code = (char)('a' + val -1);
                printEncodings(ros,result + code);
            }
            
        }
    }
}