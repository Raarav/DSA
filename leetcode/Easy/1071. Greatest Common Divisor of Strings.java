// Q->https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
// V:-https://www.youtube.com/watch?v=-nDN4idlP10
// S:-https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/3125261/fast-java-code/



class Solution {
    private int gcd(int a, int b){
        return (b==0) ? a : gcd(b, a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0,gcd(str1.length(), str2.length()));
    }
}