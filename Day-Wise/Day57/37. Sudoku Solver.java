// Q->https://leetcode.com/problems/sudoku-solver/description/
// https://www.youtube.com/watch?v=uyetDh-DyDg

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
    private void solver(char[][] board, int i, int j, char[][] dummy){
        if(i == board.length) {
            for(int s=0;s<board.length;s++){
                for(int p=0;p<board[0].length;p++){
                    dummy[s][p] = board[s][p];
                }
            }
            return;
        }
        
        int ni = 0;
        int nj = 0;
        if(j == board[0].length - 1){
            ni = i + 1;
            nj = 0;
        }else{
            ni = i;
            nj = j + 1;            
        }
        
        if(board[i][j] != '.'){
            solver(board, ni, nj, dummy);
        }else{
            for(char po='1'; po <= '9'; po++){
                if(isValid(board, i, j, po) == true){
                    board[i][j] = po;
                    solver(board, ni, nj, dummy);
                    board[i][j] = '.';
                }   
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y, char po){

        for(int j=0; j<board[0].length; j++){
            if(board[x][j] == po) return false;
        }

        for(int i=0; i<board.length; i++){
            if(board[i][y] == po) return false;
        }

        int smi = x/3 * 3;
        int smj = y/3 * 3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[smi + i][smj + j] == po) return false;
            }
        } 
        return true;
    }
    public void solveSudoku(char[][] board) {
        char[][] dummy = new char[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dummy[i][j] = board[i][j];
            }
        }
        
        solver(dummy, 0, 0, board);           
    }
}
```