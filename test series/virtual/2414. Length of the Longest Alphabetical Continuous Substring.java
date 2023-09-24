// Q->https://leetcode.com/contest/weekly-contest-311/problems/length-of-the-longest-alphabetical-continuous-substring/
// S->https://www.youtube.com/watch?v=A_T88uda3B8

class Solution {
    public int longestContinuousSubstring(String s) {
        int start = 0;
        int i = 0;
        int len = s.length();
        int maxLen = 0;
        int currLen = 0;
        while(i<len){
            while((i+1<len) && ((int)(s.charAt(i)) + 1 == (int)(s.charAt(i+1)))){
                i++;
            }
            currLen = i - start + 1;
            maxLen = Math.max(maxLen, currLen);
            i++;
            start = i;
        }
        return maxLen;
    }
}