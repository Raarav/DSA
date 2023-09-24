// Q->https://leetcode.com/problems/remove-invalid-parentheses/description/
// S->https://leetcode.com/problems/remove-invalid-parentheses/solutions/75027/easy-short-concise-and-fast-java-dfs-3-ms-solution/
// V->https://www.youtube.com/watch?v=Cbbf5qe5stw

class Solution{
    public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, new char[]{'(', ')'});
    return ans;
}

public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
    for (int stack = 0, i = last_i; i < s.length(); ++i) {
        if (s.charAt(i) == par[0]) stack++;
        if (s.charAt(i) == par[1]) stack--;
        if (stack >= 0) continue;
        for (int j = last_j; j <= i; ++j)
            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
        return;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if (par[0] == '(') // finished left to right
        remove(reversed, ans, 0, 0, new char[]{')', '('});
    else // finished right to left
        ans.add(reversed);
}
}


// mine TLE
// class Solution {
//     private void solution(String s, int mr, HashSet<String> ans){
//         if(mr == 0) {
//             int mrnow = getMin(s);
//             if(mrnow == 0){
//                 if(!ans.contains(s)){
//                     ans.add(s);
//                 }
//             }
//             return;
//         }
//         for(int i=0;i<s.length();i++){
//             String left = s.substring(0, i);
//             String right = s.substring(i+1);
//             solution(left + right, mr-1, ans);
//         }
//     }
//     private int getMin(String str){
//         Stack<Character> st = new Stack<>();
//         for(int i=0;i<str.length();i++){
//             char ch = str.charAt(i);
//             if(ch == '('){
//                 st.push(ch);
//             }else if(ch == ')'){
//                 if(st.size() == 0){
//                     st.push(ch);
//                 }else if(st.peek() == ')'){
//                     st.push(ch);
//                 }else{
//                     st.pop();
//                 }
//             }
//         }
//         return st.size();
//     }
//     public List<String> removeInvalidParentheses(String s) {
//         HashSet<String> ans = new HashSet<>();
//         solution(s, getMin(s), ans);  
//         List<String> res = new ArrayList<>();
//         Iterator<String> itr = ans.iterator();
//         while(itr.hasNext()){
//             res.add(itr.next());
//         }
//         return res; 
//     }
// }