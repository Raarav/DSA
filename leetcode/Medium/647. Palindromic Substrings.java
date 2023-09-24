// Q->https://leetcode.com/problems/palindromic-substrings/ 

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->
Tabulation in DP

# Complexity
- Time complexity:O(n^2/2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n^2)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                int gap = j - i;
                if(gap == 0){
                    dp[i][j] = true;
                    count++;
                } else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                    if(dp[i][j]) count++;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] : false;
                    if(dp[i][j]) count++;
                }
            }
        }
        return count;        
    }
}
```