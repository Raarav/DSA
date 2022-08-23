// Q->https://leetcode.com/problems/isomorphic-strings/submissions/
// TC->O(n)
// SC->O(n)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        boolean result = true;
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            char chT = t.charAt(i);
            if(hm.containsKey(ch)){
                // System.out.println("ch:-" + ch + "chT:-" + chT);
                if(hm.get(ch) != chT){
                    result = false;
                    break;
                }
            }else{
                hm.put(ch,chT);
                if(hs.contains(chT)){
                    result = false;
                    break;
                }
                hs.add(chT);
            }
            i++;
        }
        return result;
    }
}