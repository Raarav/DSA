Q->https://leetcode.com/problems/coin-change/


class Solution {
    private int recursion(int[] coins,int amount){
        if(amount == 0) return 0;
        int min = Integer.MAX_VALUE-1;
        for(int val : coins){
            if(amount - val >= 0)
                min = Math.min(min, recursion(coins, amount - val));
        }
        return min+1;
    }
    
    private int Memo(int[] coins,int amount, int[] dp){
        if(amount == 0) return 0;
        int min = Integer.MAX_VALUE-1;
        
        if(dp[amount]!=0) return dp[amount];
        
        for(int val : coins){
            if(amount - val >= 0)
                min = Math.min(min, Memo(coins, amount - val, dp) + 1);
        }
        return dp[amount] = min;
    }
    
    private int Tab(int[] coins,int amount, int[] dp){
        dp[0] = 0;        
        for(int i=1;i<dp.length;i++){
            int min = -1;
            for(int coin : coins){
                min = Math.min(min, i-coin < 0 ? -1 : dp[i-coin] + 1);     
            }
            dp[amount] = min;                
        }
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        // int min = recursion(coins, amount);
        // return min == Integer.MAX_VALUE ? -1 : min;       
        
        // int min = Memo(coins, amount, new int[amount+1]);
        // return min == Integer.MAX_VALUE-1 ? -1 : min;  
        
        int min = Tab(coins, amount, new int[amount+1]);
        return min;  
    }
}


// recursive solution >>> gives >>> Time Limit Exceeded ---- 
// different approch
class Solution {
    private int noOfCoins(int idx, int amount, int[] coins, int count){
        
        if(amount < 0) return Integer.MAX_VALUE; 
        if(amount == 0) {
            int temp = count;
            count = 0;
            return temp;
        }
        
        int result = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            result = Math.min(result, noOfCoins(i, amount - coins[i], coins, count + 1));
        }
        return result;
    }
    public int coinChange(int[] coins, int amount) { 
        if(amount == 0) return 0;
        int result = noOfCoins(0, amount, coins, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}