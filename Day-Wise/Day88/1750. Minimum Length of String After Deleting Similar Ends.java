Q->https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(logn)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int minimumLength(String s) {
        int i = 0;
        int j = s.length()-1;
        char cur = '0';
        while(i<j){
            // System.out.println(cur + ":- " + s.substring(i,j+1));
            if(s.charAt(i) == s.charAt(j)){
                cur = s.charAt(i); i++; j--; 
            }else if(cur == s.charAt(i)){
                i++;
            }else if(cur == s.charAt(j)){
                j--;
            }else{
                break;
            }         
        }      
        // System.out.println(cur + " :-" + i + ":-" + j);
        if(j==i && cur == s.charAt(i))
            return 0;
        return j-i+1 < 0 ? 0 : j-i+1 ; 
    }
}
```