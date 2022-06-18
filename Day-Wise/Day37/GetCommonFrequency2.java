// Q->https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/gce2-official/ojquestion
// TC->O(n)
// SC->O(n)

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0;i<n1;i++){
        int inp = scn.nextInt();
        if(hm.containsKey(inp)){
            int value = hm.get(inp);
            hm.put(inp,value+1);
        }else{
            hm.put(inp, 1);
        }
    }
    int n2 = scn.nextInt();
    for(int i=0;i<n2;i++){
        int inp = scn.nextInt();
        if(hm.containsKey(inp)){
            int value = hm.get(inp);
            if(value > 0){
                System.out.println(inp);
                hm.put(inp, value-1);
            }
        }else{
            // nothing to do!  
        }
    }
 }

}