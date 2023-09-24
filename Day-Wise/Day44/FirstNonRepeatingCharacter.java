// Q->https://leetcode.com/problems/first-unique-character-in-a-string/
// TC->O(n)
// SC->O(n)
class Solution {
    public int firstUniqChar(String s) {        
        Map<Character, Integer> map = new HashMap<>();   
        int i=0;
        while(s.length()>i){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
            i++;
        }
        i=0;
        while(s.length()>i){
            char ch = s.charAt(i);
            if(map.get(ch) == 1){
                return i;
            }
            i++;
        }
        return -1;
    }
}