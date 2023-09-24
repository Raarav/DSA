// Q->https://leetcode.com/contest/weekly-contest-334/problems/left-and-right-sum-differences/

class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int size = nums.length;
        int[] ls = new int[size];
        int[] rs = new int[size];
        
        for(int i=0;i<size;i++){
            if(i==0){
                ls[i] = 0;   
            }else{
                ls[i] = nums[i-1] + ls[i-1];   
            }           
        }
        
        for(int i=size-1;i>=0;i--){
            if(i+1==size){
                rs[i] = 0;
            }else{
                rs[i] = nums[i+1] + rs[i+1];
            }            
        }

        int[] result = new int[size];
        for(int i=0;i<size;i++){
            int val = rs[i] - ls[i];
            result[i] = val < 0 ? val * -1 : val; 
        }
        
        return result;
    }
}