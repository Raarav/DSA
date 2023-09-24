// Q->https://leetcode.com/problems/add-strings/description/


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public String addStrings(String num1, String num2) {
        String result = "";
        int carry = 0;
        while(num1.length() > 0 || num2.length() > 0){
            int n1 = num1.length();
            int n2 = num2.length();
            char ch1 = n1>0 ? num1.charAt(n1-1):'0';
            char ch2 = n2>0 ? num2.charAt(n2-1):'0';
            int ans = (ch1-'0') + (ch2-'0') + carry;
            result = ans%10 + result;
            carry = ans/ 10;
            num1 = n1>0 ? num1.substring(0, n1-1) : "";
            num2 = n2>0 ? num2.substring(0, n2-1) : "";
        }        
        
        return carry > 0 ? carry + result : result;
    }
}
```