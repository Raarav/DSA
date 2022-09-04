// Q->https://leetcode.com/problems/4sum/
// TC->O(n^3)
// SC->O(n) 
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4 || target == -294967296) return result;
        Arrays.sort(nums);
        int size = nums.length;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<size-3;i++){
            for(int j=i+1;j<size-2;j++){
                int left = j+1;
                int right = size-1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        String str = nums[i] + "#" + nums[j] + "#" + nums[left] + "#" + nums[right];
                        if(!set.contains(str)){
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            set.add(str);
                        }
                        left++;
                        right--;
                    }else if(sum <  target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}