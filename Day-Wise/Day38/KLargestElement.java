// Q->https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/k-largest-elements-official/ojquestion
// TC-> O(n(logn))
// SC-> O(n)
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      
      for(int val: arr){
        pq.add(val);
      }
      int size = pq.size();
      for(int i=0;i<size - k;i++){
        pq.poll();
      }
      for(int i=0;i<k;i++){
        System.out.println(pq.poll());
      }
    }
}