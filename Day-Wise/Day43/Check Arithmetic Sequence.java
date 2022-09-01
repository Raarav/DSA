// Q->https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
// TC->O(n)
// SC->O(n)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length <= 1) return true;
        
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        HashSet<Double> set = new HashSet<>();
        for(double val : arr){
            min = Math.min(val,min);
            max = Math.max(val,max);
            set.add(val);
        }
        
        double diff = (max - min) / (arr.length-1); 
        double i=0;
        if(diff != 0 && set.size() != arr.length) return false; 
        
        while(i<arr.length){
            double val = min + (i * diff);
            if(set.contains(val) == false){
                 return false;
            }
            i++;
        }
        return true;        
    }
}