// Q->https://leetcode.com/problems/4sum-ii
// Time complexity:  O(n^2)
// Space complexity: O(n^2)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int d : nums4){
            for(int c : nums3){
                int sum = d + c;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res = 0;
        
        for(int b: nums2){
            for(int a: nums1){
                int sum = b + a;
                res += map.getOrDefault(-1 * (sum), 0);
            }
        }
        
        return res;
    }
}