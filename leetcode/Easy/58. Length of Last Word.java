// Q->https://leetcode.com/problems/length-of-last-word/

class Solution {
    
    //optimized
    public int lengthOfLastWord(String s) {
        String[] output = s.split(" ");
        return output[output.length-1].length();
    }
    
    //
    public int lengthOfLastWord(String s) {
        String result = "";
        s=s.trim();
        while(s.length()!=0){
            char ch = s.charAt(0);
            if(ch == ' ')
                result = "";        
            else
                result += ch;
            s=s.substring(1);
        }        
        return result.length();
    }
}