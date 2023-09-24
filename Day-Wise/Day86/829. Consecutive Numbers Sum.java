// Q->https://leetcode.com/problems/consecutive-numbers-sum/description/
// V->https://www.youtube.com/watch?v=EiC2eIlYu_w

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->


class Solution {
    public int consecutiveNumbersSum(int n){
        int count = 0;
        for(int k=1;2*n > k * (k-1);k++){
            int numerator = n - (k * (k - 1) / 2);

            if(numerator % k == 0) count++;
        }
        return count;
    }

    // mine
    // public int consecutiveNumbersSum(int n) {
    //     int count = 1;
    //     for(int i=1;i<=n/2;i++){
    //         int val = 0;
    //         int j = i;
    //         while(j<n){
    //             val += j;
    //             if(val > n) break;
    //             else if(val == n){
    //                 count++;
    //                 System.out.println(j);
    //                 break;                    
    //             }
    //             j++;                
    //         }
    //     }
    //     return count;
    // }
}