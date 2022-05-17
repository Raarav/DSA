import java.io.*;
import java.util.*;

public class printEncodings {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str,"");
    }

    public static void printEncodings(String str,String res) {
        if(str.length() == 0){
            System.out.println(res);
            return;
        }
        int val = str.charAt(0) - '0';
        char ch = (char)('a' + val-1);
        printEncodings(str.substring(1),res + ch);
        if(str.length()>1){
            int two_digit = Integer.parseInt(str.substring(0,2));
            char ch1 = (char)('a' + two_digit-1);
            str = str.substring(2);
            if(two_digit <= 26){
                printEncodings(str,res + ch1);
            }
        }
    }
}