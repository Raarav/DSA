Q->https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/


class Solution {
    public String removeDuplicates(String s) {
        if(s.length()==1) return s;
        else{
            Stack<Character> st = new Stack<>();
            st.push(s.charAt(0));
            s = s.substring(1);
            while(s.length()>0){
                char ch = s.charAt(0);
                if(st.size() > 0 && st.peek() == ch){
                    st.pop();
                }else{
                    st.push(ch);
                }
                s = s.substring(1);
            } 
            String res = "";
            while(st.size()>0){
                res = st.pop() + res;
            }
            return res;   
        }    
    }
}