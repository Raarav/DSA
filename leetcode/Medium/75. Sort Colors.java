// Q->https://leetcode.com/problems/sort-colors/

class Solution {
    
    public void sortColors(int[] nums) {
        if(nums == null || nums.length<2) return;
        int low = 0;
        int high = nums.length-1;
        for(int i=low;i<=high;){
            if(nums[i] == 0){
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                i++; low++;
            }else if(nums[i] == 2){
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            } else{
                i++;
            }            
        }
    }
    
    
    //count
//     public void sortColors(int[] nums) {
//         int c0 = 0, c1 = 0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i] == 0){
//                 c0++;
//             }else if(nums[i]==1){
//                 c1++;
//             }
//             nums[i]=2;
//         }
        
//         for(int i=0;i<c0+c1;i++){
//             if(i<c0){
//                 nums[i]=0;
//             }else{
//                 nums[i]=1;
//             }
//         }
//     }
}