import java.io.*;
import java.util.*;

public class printPermutation {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutations(str,"");
    }

    public static void printPermutations(String str, String asf) {
        
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        
        for(int i=0;i<str.length();i++){
            String bStr = str.substring(0,i);
            char ch = str.charAt(i);
            String aStr = str.substring(i+1);
            String b_a_Str = bStr + aStr;
            printPermutations(b_a_Str,asf + ch);
        }
    }

}