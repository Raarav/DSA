// Q->https://leetcode.com/contest/weekly-contest-372/problems/make-three-strings-equal/
// S:- https://www.youtube.com/watch?v=3ECUu5wwjAE


class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int len = Math.min(s1.length(), s2.length());
        len = Math.min(len, s3.length()); // Fix here

        int ans, i = 0;

        while ( i < len) {
            if (s1.charAt(i) != s2.charAt(i) || s2.charAt(i) != s3.charAt(i))
                break;
            else   i++;
        }

       if(i == 0) return -1;
        ans = (s1.length() - i) + (s2.length() - i) + (s3.length() - i);
        return ans;
    }
}