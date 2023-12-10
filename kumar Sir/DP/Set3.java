// Q->https://drive.google.com/file/d/1aVaVeGDUlkinRW7Z1BTVY59t_exe70iA/view

import java.util.*;
import java.io.*;

class Set3 {
     public static void main(String[] arg){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = scn.nextInt();
        }
        
        int b[] = new int[n];
        for(int i=0;i<n;i++){
            b[i] = scn.nextInt();
        }
        
        int[] dp = new int[n+1];
        dp[0] = Math.max(a[0],b[0]);
        dp[1] = Math.max(dp[0], Math.max(a[1], b[1]));
        int i=2;
        while(i<n){
            int x = dp[i-1];
            int y = a[i] + dp[i-2];
            int z = b[i] + dp[i-2];
            
            dp[i] = Math.max(x, Math.max(y,z));
            i++;
        }
        System.out.println(dp[n-1]);
    }
}