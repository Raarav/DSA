// Q->https://leetcode.com/problems/unique-paths/
// S->https://leetcode.com/problems/unique-paths/discuss/182143/Recursive-memoization-and-dynamic-programming-solutions

class Solution {
    public int uniquePaths(int m, int n) {
        // return recur(new int[m][n], m-1, n-1);
        // return memoization(new int[m][n], m-1, n-1);
        return tabulation(new int[m][n], m, n);
    }
    
    // recursion
    private int recursion(int[][] matrix, int m, int n){
        if(m < 0 || n < 0) return 0;
        if(m == 0 && n == 0) return 1;
        return recursion(matrix, m-1, n) + recur(matrix, m, n-1);
    }
    
    // memoization
    private int memoization(int[][] matrix, int m, int n){
        if(m < 0 || n < 0) return 0;
        if(m == 0 || n == 0) return 1;
        if(matrix[m][n] > 0) return matrix[m][n];
        matrix[m][n] = memoization(matrix, m-1, n) + memoization(matrix, m, n-1);   
        return matrix[m][n];
    }
    
    // tabulation
    private int tabulation(int[][] matrix, int m, int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0) matrix[i][j] = 1;
                else if(j == 0) matrix[i][j] = 1;
                else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[m-1][n-1];
    }
}