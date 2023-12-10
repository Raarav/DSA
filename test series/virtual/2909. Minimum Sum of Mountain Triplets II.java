// Q->https://leetcode.com/contest/weekly-contest-368/problems/minimum-sum-of-mountain-triplets-ii/

class Solution {
    public int minimumSum(int[] nums) {
        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = nums[0];
        right[size-1] = nums[size-1];
        
        for(int i=1;i<size;i++){
            left[i] = left[i-1] > nums[i] ? nums[i] : left[i-1];
        }
        
        for(int i=size-2;i>=0;i--){
            right[i] = right[i+1] > nums[i] ? nums[i] : right[i+1];
        }
        
        int sum = Integer.MAX_VALUE;
        int i=1, j=size-1;
        while(i<size-1){
            if(left[i] != nums[i]) break;
            i++;
        }   
        
        while(j>=0){
            if(right[j] != nums[j]) break;
            j--;
        }
        
        for(int k=i;k<=j;k++){
            if(left[k] < nums[k] && right[k] < nums[k]) sum = Math.min(sum, nums[k] + left[k] + right[k]);
        }
        
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}