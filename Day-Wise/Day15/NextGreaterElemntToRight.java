import java.io.*;
import java.util.*;

public class NextGreaterElemntToRight {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) {
    // solve
    int size = arr.length;
    int[] res = new int[size];  // res == result
    Stack<Integer> st = new Stack<>();
    for(int i=size-1;i>=0;i--){
        int val = arr[i];
        if(st.empty()){
            res[i] = -1;
            st.push(val);
        }else{
            if(st.peek()>val){
                res[i] = st.peek();
                st.push(val);
            }else{
                while(st.size() != 0 && st.peek()<val){
                    st.pop();
                }
                if(st.size()==0){
                    res[i] = -1;
                }else{
                    res[i] = st.peek();
                }
                
                st.push(val);
            }
        }
    }
    return res;
  }

}