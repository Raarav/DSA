// Q->https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int Lmax = -1;
        int Rmax = -1;
        for(int i=0;i<n;i++){
            int Lid = n-1-i;
            left[Lid] = height[Lid] < Lmax ? Lmax : -1;
            Lmax = Math.max(height[Lid], Lmax);
            
            right[i] = height[i] < Rmax ? Rmax : -1; 
            Rmax = Math.max(height[i], Rmax);
        }
        
        int sum = 0;
        for(int i=0;i<n;i++){
            int min = Math.min(left[i],right[i]);
            sum += min > height[i] ? min-height[i] : 0; 
        }
        return sum;
        
    }
}