// Q->https://leetcode.com/problems/valid-palindrome-ii/description/
// V->https://www.youtube.com/watch?v=nMjhRtYg2_A

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    private boolean isPalindrome(String str, int i, int j){
        while(i<j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            i++; j--;
        }   
        return true;     
    }
}
```