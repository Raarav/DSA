// Q->https://leetcode.com/problems/number-of-islands/

class Solution {
    private void dfs(char[][] grid,boolean[][] visited, int i, int j){
        if(i<0 || i >= grid.length || j<0 || j>= grid[0].length || 
           grid[i][j] == '0' || visited[i][j] == true) return;
        visited[i][j] = true;
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j-1);
        dfs(grid, visited, i+1, j);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i, j);
                    count++;
                }                    
            }
        }  
        return count;
    }
}