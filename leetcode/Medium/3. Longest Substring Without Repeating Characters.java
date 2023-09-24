// Q->https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int strLen = 0;
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;      
            }else{
                strLen = Math.max(strLen, set.size());
                char ch1 = s.charAt(j);
                set.remove(ch1);
                j++;                
            }
        }
        return  Math.max(strLen, set.size());
    }
}