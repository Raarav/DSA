Q->https://leetcode.com/problems/spiral-matrix/description/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->
    int r = matrix.length;
    int c = matrix[0].length;
    int minX = 0;
    int maxX = r-1;
    int minY = 0;
    int maxY = c-1;

# Complexity
- Time complexity:O(n*m)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int minX = 0;
        int maxX = r-1;
        int minY = 0;
        int maxY = c-1;
        int te = r * c; // total element
        int cte = 0; // current total element
        while(cte < te){
            for(int i=minY;i<=maxY && cte < te;i++){
                result.add(matrix[minX][i]);
                cte++;
            }        
            minX++;
            for(int i=minX;i<=maxX && cte < te;i++){
                result.add(matrix[i][maxY]);
                cte++;
            }
            maxY--;
            for(int i=maxY;i>=minY && cte < te;i--){
                result.add(matrix[maxX][i]);
               cte++;
            }
            maxX--;
            for(int i=maxX;i>=minX && cte < te;i--){
                result.add(matrix[i][minY]);
                cte++;
            }
            minY++;
        }
        return result;
    }
}
```