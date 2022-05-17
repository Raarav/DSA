import java.io.*;
import java.util.*;

public class StockSpan{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   int size = arr.length;
   int[] res = new int[size];
   Stack<Integer> st = new Stack<>();
   int i=0;
   while(i<size){
       if(st.empty()){
           res[i]=i+1;
           st.push(i);
       }else{
           while(st.size() != 0 && arr[i]>arr[st.peek()]){
               st.pop();
           }
           if(st.empty()){
               res[i]=i+1;
           }else{
               res[i]=i-st.peek();
           }
           st.push(i);
       }
       i++;
   }
   return res;
 }

}