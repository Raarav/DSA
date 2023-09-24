// Q->https://leetcode.com/problems/wiggle-sort-ii/
// S->https://www.youtube.com/watch?v=mwsjU6CHOb4
//TC:- O(nlogn) SC:-O(n)

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=1;
        int j = n-1;
        int[] res = new int[n];
        while(i<n){
            res[i] = nums[j];
            i += 2;
            j--;
        }
        i=0;
        while(i<n){
            res[i] = nums[j];
            i += 2;
            j--;
        }
        for(i=0;i<n;i++){
            nums[i]=res[i];
        }
    }
}