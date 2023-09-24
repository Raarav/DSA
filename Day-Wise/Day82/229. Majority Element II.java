Q->https://leetcode.com/problems/majority-element-ii/description/


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m1 = 0, m2 = 0, c1 = 0, c2 = 0;
        for(int n : nums){
            if(m1 == n){
                c1++;
            }else if(m2 == n){
                c2++;
            }else if(c1 == 0){
                m1=n;
                c1=1;
            }else if(c2 == 0){
                m2=n;
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }  

        c1=0;
        c2=0;
        for(int v : nums){
            if(m1 == v){
                c1++;
            }else if(m2 == v){
                c2++;
            }
        }    
        List<Integer> res = new ArrayList<>();
        if(c1>(nums.length/3)) res.add(m1);
        if(c2>(nums.length/3)) res.add(m2);
        return res;
    }
}
```