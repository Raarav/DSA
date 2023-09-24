// Q->https://leetcode.com/problems/coin-change/description/


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
    public int coinChange(int[] coins, int amount) {
        // int min = recursion(coins, amount);
        // return min == Integer.MAX_VALUE ? -1 : min;       
        
        int min = Memo(coins, amount, new int[amount+1]);
        return min == Integer.MAX_VALUE-1 ? -1 : min;  
    }
}