Q->https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String ans = countAndSay(n-1);
        String result = "";
        int count = 0;
        char say = ans.charAt(0);
        for(char ch : ans.toCharArray()){
            if(say == ch){
                count++;
            }else{
                result += count+""+say;
                say = ch;
                count=1;
            }            
        }
        result += count+""+say;
        return result;
    }
}