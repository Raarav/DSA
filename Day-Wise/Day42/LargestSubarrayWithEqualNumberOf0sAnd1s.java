// Q->https://leetcode.com/problems/contiguous-array/
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length==0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0, ans = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                sum += -1;
            }else {
                sum += 1;
            }
            
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                int len = i - idx;
                if(len > ans){
                    ans = len;
                }
            }else{
                map.put(sum, i);
            }
        }
        return ans;
    }
}