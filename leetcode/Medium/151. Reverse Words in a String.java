Q->https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
S->https://www.youtube.com/watch?v=iCdzpTDn4j0

class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        String temp = "";
        String ans = "";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                if(temp.length() > 0){
                    st.push(temp);
                }
                temp = "";
            }else{
                temp = temp + s.charAt(i);
            }
        }

        ans = ans + temp;

        while(!st.isEmpty()){
            ans = ans + " " + st.pop();
        }

        if(ans.length() != 0 && ans.charAt(0) == ' ')
        {
            ans = ans.substring(1);
        }

        return ans;
    }
}