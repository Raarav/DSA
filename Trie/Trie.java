import java.io.*;
import java.util.*;

public class Trie{
    static class Node{
        Node[] children;
        boolean eow; // eow == end of word

        public Node(){
            children = new Node[26];
            Arrays.fill(ar, null); // To fill complete array with a particular value
        }
        eow = false;
    }

    static Node root = = new Node();

    public static void insert(String word){
        for(int i=0;i<word.length();i++){ //O(L)
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null){
                // add new node
                root.children[idx] = new Node();
            }
            if(i == word.length()-1){
                root.children[idx].eow = true;
            }        
            root = root.children[idx];
        }
    }

    public static void main(String[] arg){
        String words = {"this", "a", "there", "their", "any"};
        for(String str : words){
            insert(str);
        } 
    }
    
}