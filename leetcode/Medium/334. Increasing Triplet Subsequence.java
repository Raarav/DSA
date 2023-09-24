// Q->https://leetcode.com/problems/increasing-triplet-subsequence/
// S->https://leetcode.com/problems/increasing-triplet-subsequence/discuss/2725490/O(n)-Java-solution-with-comments

/*
Time Complexity: O(N)
Space Complexity: O(1)
*/

//idea : have the first and second values of the triplet initially 
class Solution {
    public boolean increasingTriplet(int[] A) {
        int n = A.length;
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(A[i] <= min) min = A[i]; //if the curr val is the min then update, because the               curr value will take care of the prev min as it is anyways smaller
            else if(A[i] <= mid) mid = A[i]; //if the curr val is less then mid, then update the             mid as it will take care of the prev mid
            else return true; //if the curr value is greater than both, we found the triplet
        }
        return false;
    }
}