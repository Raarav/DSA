// Q->https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/hfc-official/ojquestion
// TC->O(n)
// Sc->O(n)
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : str.toCharArray()){
            if(hm.containsKey(ch)){
                int val = hm.get(ch);
                hm.put(ch,val+1);
            }else{
                hm.put(ch,1);
            }
        }
        int highFrq = 0;
        char highFrqChr = 'a';
        for(char ch : hm.keySet()){
            int m = hm.get(ch);
            if(highFrq <= m){
               highFrqChr = ch;
               highFrq = Math.max(highFrq, hm.get(ch));
            }
        }
        System.out.println(highFrqChr);
    }

}