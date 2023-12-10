// Q->https://leetcode.com/problems/palindromic-substrings/description/


class Solution {
    public int countSubstrings(String s) {
        boolean[][] v = new boolean[s.length()][s.length()];

        for(int i=s.length()-1;i>=0;i--){
            for(int j=s.length()-1;j>=0;j--){
                if(s.charAt(i) == s.charAt(j)){
                        if(j-i>1 && v[i+1][j-1]){
                            v[i][j] = true;
                        }else if(j-i<=1){
                            v[i][j] = true;
                        }
                    }
            }
        }

        int count = 0;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(v[i][j]) count++;
                // System.out.print(v[i][j] + "-");
            }
            // System.out.println();
        }
        return count;
    }
}