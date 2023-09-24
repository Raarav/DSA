// Q->https://leetcode.com/problems/surrounded-regions/description/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(m+n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(m*n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    private void DFS(char[][] result,int i,int j, char[][] board){
        if(i<0 || j<0 || i>=result.length || j>=result[0].length 
            || board[i][j] == 'X' || result[i][j] == 'O') return;
        result[i][j] = 'O';
        //up
        DFS(result, i-1, j, board);
        //right
        DFS(result, i, j+1, board);
        //down
        DFS(result, i+1, j, board);
        //left
        DFS(result, i, j-1, board);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        char[][] result = new char[m][n];
        int i=0;
        for(i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j] = 'X';
            }
        }
        i=0;
        while(i<m){
            if(board[i][0] == 'O'){
                DFS(result, i, 0, board);
            }
            i++;            
        }
        i=0;
        while(i<m){
            if(board[i][n-1] == 'O'){
                DFS(result, i, n-1, board);
            }
            i++;
        }
        i=1;
        while(i<n-1){
            if(board[0][i] == 'O'){
                DFS(result, 0, i, board);
            }
            i++;
        }
        i=1;
        while(i<n-1){
            if(board[m-1][i] == 'O'){
                DFS(result, m-1, i, board);
            }
            i++;
        }

        for(i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = result[i][j];
            }
        }
    }
}
```