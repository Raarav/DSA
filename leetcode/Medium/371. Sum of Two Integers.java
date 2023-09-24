// Q->https://leetcode.com/problems/sum-of-two-integers/
// Sol :- https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation

class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = (a&b) << 1;
            a = a ^ b;
            b = carry;
        }      
        return a;
    }
}