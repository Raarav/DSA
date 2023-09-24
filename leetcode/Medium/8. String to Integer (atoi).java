// Q->https://leetcode.com/problems/string-to-integer-atoi/description/

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
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        int i = 0;

        int sign = +1;
        long ans = 0;

        if(s.charAt(0) == '-') sign = -1;

        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

        while(i < s.length()){
            int digit = s.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;
            ans = ans * 10 + s.charAt(i) - '0';
            if(sign == -1 && -1*ans < min) return min;
            if(sign == 1 && ans > max) return max;
            i++;
        }
        return (int)(sign*ans);
    }
}
```