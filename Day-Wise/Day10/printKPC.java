import java.io.*;
import java.util.*;

public class printKPC {
    
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs",
                    "tu","vwx","yz"};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str,"");
    }

    public static void printKPC(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        int val = ch - '0';
        String code = codes[val];   
        for(int j=0;j<code.length();j++){
            printKPC(str.substring(1),asf + code.charAt(j));
        }
        
    }
}