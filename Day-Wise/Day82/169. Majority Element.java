// Q->https://leetcode.com/problems/majority-element/description/


import java.util.*;
import java.io.*;

class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        if(nums.length!=0){
            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(nums[0], 1);
            for(int i=1;i<nums.length;i++){
                if(hm.containsKey(nums[i])){
                    int val = hm.get(nums[i]);
                    hm.put(nums[i],val+1);
                } else{
                    hm.put(nums[i],1);
                }                
            }
            int maxKey = 0;
            int maxValue = 0;
            for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
                if(maxValue < entry.getValue()){
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            if(maxValue>nums.length/2){
                res = maxKey;                                
            }
        }
        return res;
    }
}