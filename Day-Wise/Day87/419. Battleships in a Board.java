// Q->https://leetcode.com/problems/battleships-in-a-board/description/
// V->https://www.youtube.com/watch?v=DCa04eCUhx0
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n*m)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int countBattleships(char[][] board) {
        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='.'){
                    if(i==0 && j==0){
                        ans++;
                    }else if(i==0){
                        if(board[i][j-1] != 'X'){
                            ans++;
                        }
                    }else if(j==0){
                        if(board[i-1][j] != 'X'){
                            ans++;
                        }
                    }else{
                        if(board[i-1][j] != 'X' && board[i][j-1] != 'X'){
                            ans++;
                        }
                    }
                }
            }
        }       
        return ans; 
    }
}
```