// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-binary-strings-official/ojquestion

// Q-> Count Binary Strings

import java.io.*;
import java.util.*;

public class n4_count_binary_string{
    private static int recursive(int n){
        if(n < 0) return 0;
        if(n==1) return 2;
        if(n==2) return 3;
        return recursive(n-2) + recursive(n-1);
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int result = recursive(n);
        System.out.print(result);
     }

}