// Q->https://leetcode.com/problems/perfect-squares/
// S->https://www.youtube.com/watch?v=aJTCcyPrPOA

class Solution {
    
    private int recur(int n){
        if(n == 0) return n;
        int min = n;
        for(int i=1;i*i<=n;i++){
            int temp = i*i;
            min = Math.min(min, 1+recur(n-temp));
        }   
        return min;
    }
    private int memo(int n, int[] dp){
        if(n == 0) return n;
        
        if(dp[n] != 0) return dp[n];
        int min = n;
        for(int i=1;i*i<=n;i++){
            int temp = i*i;
            min = Math.min(min, 1+memo(n-temp, dp));
            dp[n]=min;
        }   
        return dp[n];
    }
    private int tabulation(int n){
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            int j = 1;
            int min = i;
            while(j*j <= i){
                min = Math.min(min, dp[i-j*j]);
                j++;
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
    public int numSquares(int n) {
        // return recur(n);  
        // return memo(n, new int[n+1]);
        return tabulation(n);
    }
    
    
    ///mine but not able to convert into memo
//     private int recur(int size, int count, int rest){
//         if(rest < 0) return Integer.MAX_VALUE;
//         if(rest == 0) return count;
        
//         int min = Integer.MAX_VALUE;
//         for(int i=1;i<=size;i++){
//             int val = recur(size, count + 1, rest - i*i);
//             min = Math.min(val, min);
//         }   
//         return min;
//     }
//     public int numSquares(int n) {
//         return recur((int)Math.sqrt(n), 0, n);      
//     }
}