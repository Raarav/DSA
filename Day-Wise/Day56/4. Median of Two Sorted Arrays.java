// Q->https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// S->https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/3094250/clean-java-code-optimized-2ms-100-beats-binary-search/
// V:-https://www.youtube.com/watch?v=jDJuW7tSxio

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(log(m+n))
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        int lo = 0;
        int hi = a.length;
        int te = a.length + b.length;

        while(lo <= hi){
            int aleft = (lo + hi)/2;
            int bleft = (te + 1)/2 - aleft;

            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft-1];
            int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft-1];
            int bl = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft];

            if(alm1 <= bl && al >= blm1){
                double median = 0.0;

                if(te % 2 ==0){
                    int lmax =  Math.max(alm1, blm1);
                    int rmin = Math.min(al, bl);
                    median = (lmax + rmin)/2.0;
                }else{
                    int lmax = Math.max(alm1, blm1);
                    median = lmax;
                }
                return median; 
            } else if(alm1 > bl){
                hi = aleft - 1;
            } else if(blm1 > al) {
                lo = aleft + 1;
            }
        }   
        return 0.0;
    }
}
```