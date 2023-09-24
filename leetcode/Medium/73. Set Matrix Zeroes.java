// Q->https://leetcode.com/problems/set-matrix-zeroes/
// S->

class Solution {
    
    //optimal
    public void setZeroes(int[][] matrix){

		int m=matrix.length, n=matrix[0].length;
        boolean isRow0=false, isCol0=false;
        
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
                isRow0=true;
        }
        
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
                isCol0=true;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }
        
        if(isRow0){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }
        
        if(isCol0){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
    }
    
    //mine
//     private void rowZeros(int[][] matrix, int row){
//         for(int i=0;i<matrix[row].length;i++){
//             matrix[row][i] = 0;
//         }     
//     }
//     private void colZeros(int[][] matrix, int col){
//         for(int i=0;i<matrix.length;i++){
//             matrix[i][col] = 0;
//         }        
//     }
//     public void setZeroes(int[][] matrix) {
//         Map<Integer, Integer[]> map = new HashMap<>();
//         int key = 0;
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[0].length;j++){
//                 if(matrix[i][j] == 0){
//                     map.put(key++, new Integer[] {i,j});
//                 }
//             }
//         }
        
//         for(Map.Entry<Integer, Integer[]> e : map.entrySet()){
//             rowZeros(matrix, e.getValue()[0]);
//             colZeros(matrix, e.getValue()[1]);
//         }
//     }
}
