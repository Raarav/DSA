// Q->https://leetcode.com/problems/partition-labels/description/
// V->https://www.youtube.com/watch?v=_I9di3CUOx4

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 1. filling of impact of characters
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }        

        // 2. making of result
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if(max == i){
                res.add(max - prev);
                prev = max;
            }
        }

        return res;
    }
}
```