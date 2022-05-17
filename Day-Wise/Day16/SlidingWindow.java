import java.io.*;
import java.util.*;

public class SlidingWindow{
    private static int[] NGE(int size, int[] arr){ //NGE == Next greater element
        int[] res = new int[size];
        Stack<Integer> st = new Stack<Integer>(); // res == result
        int i=size-1;
        while(i>=0){
            if(st.empty()){
                res[i]=size;
                st.push(i);
            }else{
                while(st.size() != 0 && arr[st.peek()] < arr[i]){
                    st.pop();
                }
                if(st.empty()){
                    res[i]=size;
                    st.push(i);
                }else{
                    res[i]=st.peek();
                    st.push(i);
                }
            }
            i--;
        }
        return res;
    }
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    int size = arr.length;
    int[] nge = NGE(size, arr);
    // for(int v : nge){ // checking next greater element array is coming right or not?
    //     if(v == size){
    //         System.out.print(Integer.MAX_VALUE + ", ");
    //     }else{
    //         System.out.print(arr[v] + ", ");
    //     }
    // }
    // System.out.println();
    int j=0;
    for(int i=0;i<=arr.length-k;i++){
        if(j<i){
            j=i;
        }
        while(nge[j] < i + k){
            j = nge[j];
        }
        System.out.println(arr[j]);
    }
 }
}