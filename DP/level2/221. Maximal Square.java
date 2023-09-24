// Q->https://leetcode.com/problems/maximal-square/description/
// V->https://www.youtube.com/watch?v=UagRoA3C5VQ

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(m*n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(m*n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j] != '0'){
                    if(j==n-1 || i==m-1){
                        dp[i][j] = 1;                  
                    }
                    else {
                        int right = dp[i][j+1];
                        int down = dp[i+1][j];
                        int diaglon = dp[i+1][j+1];
                        dp[i][j] = 1 + Math.min(right, Math.min(down, diaglon));
                    }
                    max = Math.max(max, dp[i][j]);                    
                }             
            }
        }
        return max*max;
    }
}
```