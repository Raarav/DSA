// Q-https://atcoder.jp/contests/dp/tasks/dp_b

import java.util.*;
import java.io.*;

class HelloWorld {
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] b = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            b[i] = scn.nextInt();
        }
        
        int[] dp = new int[n+1];
        
        dp[1] = 0;
        dp[2] = Math.abs(b[1] - b[2]);
        for (int i = 3; i <= n; i++) {
            int j = 1;
            int ans = Integer.MAX_VALUE;
            while(j<=k && i-j >= 1){
                int val = Math.abs(b[i] -b[i-j]);
                int ops = dp[i-j] + val;
                ans = Math.min(ops, ans);
                j++;
            }
            dp[i] = ans;
        }
            
        System.out.println(dp[n]);
    }
}