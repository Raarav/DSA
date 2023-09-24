// Q->https://leetcode.com/problems/combination-sum-iv/description/
// V->https://www.youtube.com/watch?v=Wct0mN2SCRQ

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    private int recursion(int amount,int[] coins){
        if(amount == 0) return 1;
        if (amount < 0) return 0;
        int res = 0;
        for(int i=0;i<coins.length;i++){
            res += recursion(amount - coins[i], coins);
        }
        return res;
    }
    private int memo(int[] nums, int amount, int[] dp){
        if(amount == 0) return 1;
        if(amount < 0) return 0;

        if(dp[amount] != 0) return dp[amount];
        
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res += memo(nums, amount - nums[i], dp);
        }        

        return dp[amount] = res; 
    }
    private int Tabo(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0]=1; 
        for(int i=1;i<=target;i++){
            int j = 0;
            for(;j<nums.length; j++){
                if(i - nums[j] >= 0)
                    dp[i] += dp[i - nums[j]];  
            }
        }   

        return dp[target]; 
    }
    public int combinationSum4(int[] nums, int target) {
        // return recursion(target, nums);
        // int[] dp = new int[target+1];
        // return memo(nums, target, dp);
        return Tabo(nums, target);
    }
}
```