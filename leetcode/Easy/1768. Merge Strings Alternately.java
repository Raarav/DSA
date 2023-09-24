Q->https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        while(word1.length() > 0 && word2.length() > 0){
            char ch1 = word1.charAt(0);
            char ch2 = word2.charAt(0);
            word1 = word1.substring(1);
            word2 = word2.substring(1);
            res += ch1 + "";
            res += ch2 + "";
        }   
        if(word1.length() > 0){
            res += word1;
        }   
        if(word2.length() > 0){
            res += word2;
        }   
        return res;     
    }
}