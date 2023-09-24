// Q->https://leetcode.com/problems/factorial-trailing-zeroes/
// V->https://www.youtube.com/watch?v=nnmS7PEnvy8
// Another solution V:->https://www.youtube.com/watch?v=fx8rUY_iIms

class Solution {

    public int trailingZeroes(int n) {
        
        int count = 0;
        while(n > 0){
            n /= 5;
            count+=n;            
        }
        return count;
        //mine gives TLE
//         if(n==0) return 0;
//         int factorial = 1;
//         for(int i=1;i<=n;i++){
//             factorial *= i;
//         }        
        
//         int count = 0;
//         while(factorial%10==0){
//             factorial /= 10; count++;
//         }
            
//         return count;
    }
}