Q->https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for(int e : nums){
            // System.out.println(e);
            if(res == 0 || res == 1 || nums[res - 2] != e){
                nums[res] = e;
                res += 1;
            }
        }
        return res;
    }
}