// Q->https://leetcode.com/problems/complex-number-multiplication/description/
// V->https://leetcode.com/problems/complex-number-multiplication/solutions/2737160/java-faster-than-92-magic-of-regex/

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
    public String complexNumberMultiply(String num1, String num2) {
        String arr1[] = num1.split("\\+");
        String arr2[] = num2.split("\\+");
        int real = 0, img = 0;
        int temp1 = Integer.parseInt(arr1[0]);
        int temp2 = Integer.parseInt(arr1[1].replace("i",""));
        int temp3 = Integer.parseInt(arr2[0]);
        int temp4 = Integer.parseInt(arr2[1].replace("i",""));
        real = temp1*temp3 - temp2*temp4; // i2 == -1;
        img = temp1*temp4 + temp2*temp3;
        StringBuilder sb = new StringBuilder();
        sb.append(real);
        sb.append("+");
        sb.append(img);
        sb.append("i");
        return sb.toString();
    }
}
```