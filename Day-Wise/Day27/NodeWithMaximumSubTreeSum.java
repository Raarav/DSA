// Q-> https://www.pepcoding.com/resources/online-java-foundation/generic-tree/node-with-maximum-subtree-sum-official/ojquestion
// TC->O(n)
// SC->O(1)

import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
    static int nMn;
    static int sMn;
  public static int nwmss(Node node){
      
      int sum = 0;
      for(Node child : node.children){
          int val = nwmss(child);
          sum += val;
      }
      sum += node.data;
    if(sMn < sum){
          nMn = node.data;
          sMn = sum;
        }
        return sum;
  } 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    nMn = 0; // nMn == name of max node
    sMn = Integer.MIN_VALUE; // sMn == sum of max node
    nwmss(root);
    System.out.println(nMn+"@"+sMn); // nwmss == node with maximum substree sum 
  }

}