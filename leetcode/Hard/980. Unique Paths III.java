// Q->https://leetcode.com/problems/unique-paths-iii/description/

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
    private int recursion(int[][] grid, int cz, int i, int j, boolean[][] visited){
        if(i<0 || j<0|| i>=grid.length || j>=grid[0].length 
            || (cz > 0 && grid[i][j] == 2) 
            || visited[i][j] == true) return 0;
        if(cz == 0 && grid[i][j] == 2) return 1;

        visited[i][j] = true;

        int right = recursion(grid, cz-1, i, j+1, visited);
        int down = recursion(grid, cz-1, i+1, j, visited);
        int left = recursion(grid, cz-1, i, j-1, visited);
        int up = recursion(grid, cz-1, i-1, j, visited);

        visited[i][j] = false;

        return right + down + left + up;
    }
    public int uniquePathsIII(int[][] grid) {
        int cz = 0; // count zero
        int[] one = new int[2];
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    cz++;
                }else if(grid[i][j]==1){
                    one[0] = i;
                    one[1] = j;
                }
                if(grid[i][j] == -1){
                    visited[i][j] = true;
                }
            }
        }
        return recursion(grid, cz+1, one[0], one[1], visited);        
    }
}
```