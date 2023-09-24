// Q->https://leetcode.com/problems/multiply-strings/description/
// S->https://leetcode.com/problems/multiply-strings/solutions/17605/easiest-java-solution-with-graph-explanation/

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
class Solution{
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m+n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

// mine solution
// class Solution {
//     public String multiply(String num1, String num2) {
//         long result = 0;
//         int carry = 0;
//         int j = 0;
//         for(;num2.length()>j;){
//             int n2 = num2.length();
//             char ch2 = num2.charAt(n2-j-1);
//             carry = 0;
//             long ans = 0;
//             int i=0;
//             for(;num1.length()>i;){
//                 int n1 = num1.length();
//                 char ch1 = num1.charAt(n1-i-1);
//                 int val = ((ch1-'0') * (ch2-'0') + carry);
//                 carry = val / 10;
//                 val = val % 10;
//                 ans += val*Math.pow(10,i);
//                 i++;
//             }
//             if(carry>0){
//                 ans += carry * Math.pow(10,i);
//             }            
//             result += (ans*Math.pow(10,j));
//             j++;
//         }     
//         return result + "";   
//     }
// }
```