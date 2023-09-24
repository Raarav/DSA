// Q->https://leetcode.com/problems/word-search/description/

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
    private boolean DFS(char[][] board, boolean[][] visited, String word,int n,int i, int j){
        if(n==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j >= board[0].length || visited[i][j] 
            || board[i][j] != word.charAt(n)) return false;

        visited[i][j] = true;
        // up
        boolean up = DFS(board, visited, word, n+1, i-1, j);
        // right
        boolean right = DFS(board, visited, word, n+1, i, j+1);
        // down
        boolean down = DFS(board, visited, word, n+1, i+1, j);
        // left
        boolean left = DFS(board, visited, word, n+1, i, j-1);
        
        visited[i][j] = false;
        
        return up || right || down || left;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean[][] visited = new boolean[m][n];
                if(DFS(board, visited, word, 0, i, j)) return true;
            }
        }
        return false;
    }
}
```