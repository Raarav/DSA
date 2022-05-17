// Q - > 64. Minimum Path Sum ( https://leetcode.com/problems/minimum-path-sum/ )

// leetcode 
class Solution {
    private int recursive(int[][] grid,int i, int j,int m, int n){
        if(i == m-1 && j == n-1) return grid[m-1][n-1];
        if(j >= n ) return 101;
        if(i >= m ) return 101;
        
        int right = recursive(grid, i, j+1, m, n);
        int down = recursive(grid, i+1, j, m, n);
        
        return grid[i][j] + Math.min(right,down);
    }
    
    private int dpMemo(int[][] grid,int i, int j,int m, int n,int[][] dp){
        if(i == m-1 && j == n-1) return grid[m-1][n-1];
        if(j >= n ) return 101;
        if(i >= m ) return 101;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int right = recursive(grid, i, j+1, m, n);
        int down = recursive(grid, i+1, j, m, n);
        
        return dp[i][j] = grid[i][j] + Math.min(right,down);
    }    
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // return recursive(grid , 0, 0, m, n);
        
        // dp strorage
        int[][] dp = new int[m][n];
        
        //------ memoziation 

        // for(int i=0;i<m;i++)
        //     for(int j=0;j<n;j++)
        //         dp[i][j] = -1;
        
        // return dpMemo(grid, 0, 0, m, n, dp);       
        
        
        
        //------bottom up
        
        dp[0][0] = grid[0][0];
        
        // for 1st row filling
        for(int i=1;i<m;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];            
        }   
        
        // for 1st column filling
        for(int j=1;j<n;j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        // filling rest columns
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];                    
            }
        }
        return dp[m-1][n-1];
    }
}