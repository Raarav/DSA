import java.io.*;
import java.util.*;

public class getStairPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.print(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        if(n<0) {
            ArrayList<String> ans = new ArrayList<>();
            return ans;
        }
        
        ArrayList<String> one = getStairPaths(n-1);
        ArrayList<String> two = getStairPaths(n-2);
        ArrayList<String> three = getStairPaths(n-3);
        
        ArrayList<String> result = new ArrayList<>();
        
        for(int i=0;i<one.size();i++){
            result.add(1 + one.get(i));
        }
        
        for(int i=0;i<two.size();i++){
            result.add(2 + two.get(i));
        }
        
        for(int i=0;i<three.size();i++){
            result.add(3 + three.get(i));
        }
        
        return result;
    }

}