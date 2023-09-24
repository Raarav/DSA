Q->https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

import java.util.*;
import java.io.*;

public class Main
{
    private int V;
    private LinkedList<Integer> adj[];
    
    Main(int val){
        V = val;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i] = new LinkedList();
        }
    }
    void addEdge(int v, int w){
        adj[v].add(w); 
    }
    
    void display(){
        for(int i=0;i<V;i++){
            System.out.print(i + "->");
            LinkedList<Integer> al = adj[i];
            for(int j=0;j<al.size();j++){
                System.out.print(al.get(j) + ", ");
            }
            System.out.println(".");
        }
    }
    
    void BFS(int start){
        
        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(q.size()!=0){
            int val = q.remove();
            System.out.print(val + " ");

            LinkedList<Integer> nbr = adj[val];
            for(int i=0;i<nbr.size();i++){
                int vL = nbr.get(i);
                if(!visited[vL]){
                    visited[vL] = true;
                    q.add(vL);
                }
                
            }
            
        }
    }

    void BFS_forDisconnectedGraph(){
        boolean visited[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>();
            q.add(i);
            
            visited[i] = true;
            while(q.size()!=0){
                int val = q.remove();
                System.out.print(val+" ");
                LinkedList<Integer> nbr = adj[val];
                for(int j=0;j<nbr.size();j++){
                    int vL = nbr.get(j);
                    if(!visited[vL]){
                        visited[vL] = true;
                        q.add(vL);
                    }
                }
            }
            }
        }
    }
    
	public static void main(String[] args) {
	    Main g = new Main(4);
	    
	    g.addEdge(0,1);
	    g.addEdge(0,2);
	    g.addEdge(2,3);
	    g.addEdge(1,2);
	    g.addEdge(2,0);
	    g.addEdge(3,3);
	   // g.display();
	   g.BFS(2);
	}
}
