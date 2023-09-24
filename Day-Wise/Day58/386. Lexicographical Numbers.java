// Q->https://leetcode.com/problems/lexicographical-numbers/description/
// S->https://www.youtube.com/watch?v=gRo86WqFYSE


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    private void dfs(List<Integer> res, int i, int n){
        if(i > n) return;

        res.add(i);

        for(int j=0;j<10;j++){
            dfs(res,10*i + j, n);
        }        
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(res, i, n);
        }        
        return res;
    }
}
```