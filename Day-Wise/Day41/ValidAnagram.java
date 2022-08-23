// Q->https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String p) {
        if(s.length() != p.length()) return false;

        HashMap<Character, Integer> characters = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            characters.put(ch, characters.getOrDefault(ch, 0) + 1);
        }   

        for(int i=0;i<p.length();i++){
							if(characters.containsKey(p.charAt(i)) && characters.get(p.charAt(i))>0){   //if char found in string "t" decrease the char value by 1
								int temp = characters.get(p.charAt(i));
								characters.put(p.charAt(i),temp-1);
							}
							else{
								return false;
							}
				}
				return true;
    }
}