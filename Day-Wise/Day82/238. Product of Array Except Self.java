Q->https://leetcode.com/problems/product-of-array-except-self/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //method2
        int size = nums.length;
        int[] left = new int[size];
        
        int product = 1;
        for(int i=0;i<size;i++){
            product = nums[i]*product;
            left[i] = product;
        }
        
        product = 1;
        
        for(int i=size-1;i>=0;i--){
            if(i==0) left[i] = product;
            else{
                left[i] = left[i-1]*product;
            }        
            product = nums[i]*product;
        }
        return left;
        //method1
//         int size = nums.length;
//         int[] left = new int[size];
//         int[] right = new int[size];
        
//         int product = 1;
//         for(int i=0;i<size;i++){
//             product = nums[i]*product;
//             left[i] = product;
//         }
        
//         product = 1;        
//         for(int i=size-1;i>=0;i--){
//             product = nums[i]*product;
//             right[i] = product;
//         }
        
//         int[] result = new int[size];
//         for(int i=0;i<size;i++){
//             if(i==0) result[i] = right[1];
//             else if(i==(size-1)) result[i] = left[size-2];
//             else{
//                 result[i] = left[i-1] * right[i+1];
//             }
//         }
//         return result;
    }
}