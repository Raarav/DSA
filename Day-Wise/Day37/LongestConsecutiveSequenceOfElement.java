// Q->https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/lcqs-official/ojquestion
// TC->O(n)
// SC->O(n)
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    HashMap<Integer, Boolean> hm = new HashMap<>();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
    }
    for(int i=0;i<n;i++){
        int val = arr[i];
        hm.put(val, true);
    }
    
    for(int i=0;i<n;i++){
        int val = arr[i];
        if(hm.containsKey(val-1)){
            hm.put(val,false);
        }
    }
    
    int msp = 0;
    int ml = 0;
    for(int val: arr){
        if(hm.get(val)){
            int tl = 1;
            int tsp = val;
            
            while(hm.containsKey(tsp + tl)){
                tl++;
            }
            
            if(tl > ml){
                msp = tsp;
                ml = tl;
            }
        }
    }
    
    for(int i = 0;i < ml; i++){
        System.out.println(msp + i);
    }
 }

}