// Q->https://leetcode.com/problems/search-a-2d-matrix-ii/
// S->https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/2324616/JavaC%2B%2B-FULL-VISUALL-explanation

class Solution {
    
    //simple solution
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     for(int i = 0; i < matrix.length; i++){
    //         for(int j = 0; j < matrix[0].length; j++){
    //             if(matrix[i][j] == target) return true;
    //         }
    //     }
    //     return false;
    // }
    
    //optimize solution
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m=matrix[0].length;
        int i=0, j=m-1;
        while(i<n&&j>=0){
            if(target==matrix[i][j]){
                // System.out.println(matrix[i][j]);
                return true;}
            if(target>matrix[i][j]){
                // System.out.println(matrix[i][j]);
                i+=1;}
            else{
                // System.out.println(matrix[i][j]);
                j-=1;
            }
            
        }
        
        return false;
    }
}