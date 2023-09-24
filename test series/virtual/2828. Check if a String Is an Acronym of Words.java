Q->https://leetcode.com/contest/weekly-contest-359/problems/check-if-a-string-is-an-acronym-of-words/

class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String temp = "";
        for(int i=0;i<words.size();i++){
            temp += words.get(i).charAt(0);
        }        
        return temp.equals(s) ? true : false;
    }
}