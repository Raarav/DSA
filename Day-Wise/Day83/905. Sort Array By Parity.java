// Q->https://leetcode.com/problems/sort-array-by-parity/description/



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
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int e = 0;
        int o = nums.length-1;
        while(e<o){
            if(nums[e]%2==1){
                if(nums[o]%2==0){
                    swap(nums, e, o);   
                    e++;
                    o--;                 
                }else{
                    while(e<o && nums[o]%2 != 0){
                        o--;
                    }
                    swap(nums, e, o);   
                    e++;
                    o--; 
                }
            }else{
                e++;
            }
        }       
        return nums;
    }
}
```