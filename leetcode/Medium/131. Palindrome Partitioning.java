// Q->https://leetcode.com/problems/palindrome-partitioning/description/
// (Effective solution)S->https://leetcode.com/problems/palindrome-partitioning/solutions/41967/my-java-solution-7ms/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    private boolean isPalindrome(String str){
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    private void partician(String s, List<List<String>> res, List<String> ans){
        if(s.length()==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<s.length();i++){
            String prefix = s.substring(0, i + 1);
            String sufix = s.substring(i+1);
            if(isPalindrome(prefix)){
                ans.add(prefix);
                partician(sufix, res, ans);
                ans.remove(ans.size()-1);
            }
        }
    } 
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        partician(s, res, ans);
        return res;
    }
}
```