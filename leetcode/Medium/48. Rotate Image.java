Q->https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        int[][] trans = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                trans[j][i] = matrix[i][j]; 
            }
        }        

        int i=0, j=matrix[0].length-1;

        while(i<j){
            for(int k=0;k<matrix.length;k++){
                int val = trans[k][i];
                trans[k][i] = trans[k][j];
                trans[k][j] = val;
            }
            i++; j--;
        }

        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                matrix[i][j] = trans[i][j]; 
            }
        }
    }
}