import java.io.*;
import java.util.*;

class BinaryTreeContructorAndDisplay{

    static Integer[] arr = [10, 20, 40, null, null, 50, null, null, 30, 60, 100, null, null, null, 70, null, 120];

    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void construct(Node node){
        Stack<Pair> st = new Stack<>();
        st.push(Pair(root, 1));
        int idx = 1;
        while(!st.empty()){
            Node top = st.peek();
            if(top.state == 1){
                if(arr[idx] != null){
                    Node tmp = new Node(arr[idx],null,null);
                    top.node.left = tmp; 
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }                               
                top.state++;                
            }else if(top.state == 2){
                if(arr[idx] != null){
                    Node tmp = new Node(arr[idx],null,null);
                    top.node.right = tmp; 
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }                               
                top.state++;
            }else{
                st.pop();
            }
            idx++;
        }                
    }

    public static void main(String[] args){
        Node root = new Node(arr[0], null, null);
        construct(root);
    }
}