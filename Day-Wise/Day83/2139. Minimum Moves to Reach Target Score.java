// Q->https://leetcode.com/problems/minimum-moves-to-reach-target-score/description/
// S->https://leetcode.com/problems/minimum-moves-to-reach-target-score/solutions/1694930/jump-game-100-faster-100-less-memory-usage/
// // S->https://leetcode.com/problems/minimum-moves-to-reach-target-score/solutions/1693327/java-c-python-reduce-target-to-1/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(long)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int minMoves(int target, int k) {
        int res = 0;
        while (target > 1 && k > 0) {   
            res += 1 + target % 2;
            k--;
            target >>= 1;
        }
        return target - 1 + res;
    }
}
// class Solution {
//     private int recursion(int t, int md, int n){
//         if(n>t) return Integer.MAX_VALUE;
//         if(t == n) return 0;

//         int s = recursion(t, md, n+1);
//         int d = Integer.MAX_VALUE;
//         if(md>0){
//             d = recursion(t, md-1, 2*n);
//         }
//         return Math.min(s , d) + 1;
//     }
//     public int minMoves(int target, int maxDoubles) {
//         return recursion(target, maxDoubles, 1);        
//     }
// }
```