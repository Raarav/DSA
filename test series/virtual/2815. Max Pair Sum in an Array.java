Q->https://leetcode.com/contest/weekly-contest-358/problems/max-pair-sum-in-an-array/

class Solution {
    public int maxSum(int[] nums) {
        int res = -1;
        for(int i=0;i<nums.length;i++){
            String pr1 = nums[i] + "";
            char[] arr1 = pr1.toCharArray();
            Arrays.sort(arr1);
            int max1 = arr1[arr1.length-1];
            for(int j=i+1;j<nums.length;j++){
                String pr2 = nums[j] + "";
                char[] arr2 = pr2.toCharArray();
                Arrays.sort(arr2);
                int max2 = arr2[arr2.length-1];
                if(max1 == max2) {
                    res = Math.max(res, nums[i] + nums[j]);
                }
            }
        }
        return res;
    }
}