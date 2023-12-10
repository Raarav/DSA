// i/p :- N = 11 || o/p :- dba
// i/p :- N = 1  || o/p :- a
// i/p :- 67108876 || o/p :- zzdc

import java.util.*;
import java.io.*;

class YashikaTestDPQ{
   public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 1;
        
        String res = "";
        int i=25;
        while(n>=1 && i>=0){
            int val = (int)Math.pow(2, i);
            int div = 0;
            div = n/val;
            while(div > 0){
                res += (char)(i+'a');
                div--;
            }
            n %= val;
            i--;
        }

        System.out.println(res);
    }
}