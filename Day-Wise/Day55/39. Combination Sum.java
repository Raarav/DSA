// Q->https://leetcode.com/problems/combination-sum/description/
// S->https://leetcode.com/problems/combination-sum/solutions/3102544/java-backtracking-explained/


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
    private void recursion(int[] coins, int amount, List<List<Integer>> res, List<Integer> ans, int n){
        if(amount == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(amount < 0){
            return;
        }

        for(int i=n;i<coins.length;i++){
            ans.add(coins[i]);      
            recursion(coins, amount-coins[i], res, ans, i);
            ans.remove(ans.size()-1);      
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(candidates, target, res, new ArrayList<>(), 0);   
        return res;     
    }
}
```