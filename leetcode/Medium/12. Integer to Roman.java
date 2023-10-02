Q->https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
S->https://www.youtube.com/watch?v=Rsq1ObYg6ak

TC-> O(n)
SC-> O(n)

class Solution {
    public String intToRoman(int num) {
        int[] d = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] ds = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

        String res = "";
        int i=d.length-1;
        while(num != 0){
            if(num >= d[i]){
                num = num - d[i];
                res += ds[i];
            }
            if(num < d[i]){
                i--;
            }
        }   
        return res;
    }
}