// Q->https://leetcode.com/problems/longest-palindromic-substring/description/


class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] v = new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s.charAt(i) == s.charAt(j)){
                    if((j-i <= 1) || (j-i>1 && v[i+1][j-1])){
                        v[i][j] = true;
                    }
                }
            }
        }
        String strl = "";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub = s.substring(i, j+1);
                if(v[i][j]){
                    if(strl.length() < sub.length()){
                        strl = sub;
                    }
                }
            }
        }
        return strl;
    }
}