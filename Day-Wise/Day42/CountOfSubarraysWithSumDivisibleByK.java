// Q->https://leetcode.com/problems/subarray-sums-divisible-by-k/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int key = sum % k;
            if(key<0){
                key += k;
            }
            if(map.containsKey(key)){
                ans += map.get(key); 
                map.put(key,map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
            
        }
        return ans;
    }
}