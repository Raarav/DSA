import java.io.*;
import java.util.*;

public class getMazePathWithMultipleJump {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.print(getMazePaths(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String>  getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> horizontal = new ArrayList<>();
        for(int i=1;i<=dc-sc;i++){
            horizontal = getMazePaths(sr, sc + i, dr, dc);
            for(int j=0;j<horizontal.size();j++){
                result.add("h" + i + horizontal.get(j));
            }
        }
        ArrayList<String> vertical = new ArrayList<>();
        for(int i=1;i<=dr-sr;i++){
            vertical = getMazePaths(sr + i, sc, dr, dc);
            for(int j=0;j<vertical.size();j++){
                result.add("v" + i + vertical.get(j));
            }
        }
        ArrayList<String> diagonal = new ArrayList<>();
        for(int i=1;i<=dr-sr && dc<=dc-sc;i++){
            diagonal = getMazePaths(sr + i, sc + i, dr, dc);
            for(int j=0;j<diagonal.size();j++){
                result.add("d" + i + diagonal.get(j));
            }
        }
        return result;
    }
}