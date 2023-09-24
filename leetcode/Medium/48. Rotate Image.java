Q->https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                result[j][i] = matrix[i][j];
            }
        }
        
        for(int j=0;j<n/2;j++){
            for(int i=0;i<m;i++){
                 int temp = result[i][j];  
                 result[i][j] = result[i][(m-1)-j];
                 result[i][(m-1)-j] = temp;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 matrix[i][j] = result[i][j];
            }
        }
        
    }
}