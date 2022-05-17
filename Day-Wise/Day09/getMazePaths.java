import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.print(getMazePaths(0,0,n,m));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr-1 && sc == dc-1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        if(sr == dr || sc == dc) {
            ArrayList<String> ans = new ArrayList<>();
            return ans;
        }
        ArrayList<String> horizontal = getMazePaths(sr+1,sc, dr, dc);
        ArrayList<String> vertical = getMazePaths(sr,sc+1,dr,dc);
        
        ArrayList<String> result = new ArrayList<>();
        
        for(int i=0;i<horizontal.size();i++){
            result.add("h" + horizontal.get(i));
        }
        for(int i=0;i<vertical.size();i++){
            result.add("v" + vertical.get(i));
        }
    
        return result;
    }

}