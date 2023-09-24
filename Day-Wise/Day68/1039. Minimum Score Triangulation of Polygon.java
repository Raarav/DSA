// Q->https://leetcode.com/problems/minimum-score-triangulation-of-polygon/description/
// V->https://www.youtube.com/watch?v=dvTTtzamEEo
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
    private int Memo(int[] v, int i, int j, int[][] dp){
        if(i+1 == j) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans = Math.min(ans, v[i]*v[j]*v[k] + Memo(v, i, k, dp) + Memo(v, k, j, dp));
        }

        dp[i][j] = ans;

        return dp[i][j];
    }
    private int recursion(int[] v, int i, int j){
        if(i+1 == j) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i+1; k<j;k++){
            ans = Math.min(ans, v[i]*v[j]*v[k] + recursion(v, i, k) + recursion(v, k, j));
        }
        return ans;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        // return recursion(values, 0, n-1);   

        int[][] dp = new int[n][n];
        return Memo(values, 0, n-1, dp);     
    }
}
```