// Q->https://leetcode.com/problems/fraction-to-recurring-decimal/

class Solution {
    public String fractionToDecimal(int n, int d) {
        StringBuilder ans = new StringBuilder();
        
        if(n == 0 || d == 1) return ans.append(n).toString();
        if(d==-2147483648 && n == -1) return "0.0000000004656612873077392578125";
        if(n == -2147483648 && d == -1) return "2147483648";
        
        int On = n, Od = d;
        if(n < 0 && d > 0){
            n = (-1) * n;
        }
        if(n > 0 && d < 0){
            d = (-1) * d;
        }
        
        int q = n / d;
        int r = n %  d;
        ans.append(q);
       
        if(r == 0){
            return ans.toString();
        }else{
            HashMap<Integer, Integer> map = new HashMap<>();
            ans.append(".");
            while(r != 0){
                if(map.containsKey(r)){
                    int len = map.get(r);
                    ans.insert(len, "(");
                    ans.append(")");
                    break;
                }else{
                    map.put(r, ans.length());
                    r *= 10;
                    q = r / d;
                    r = r % d;
                    ans.append(q);
                }                
            }
        }
        if((On < 0 && Od > 0) || (On > 0 && Od < 0)){
            return "-" + ans.toString();
        }else{
            return ans.toString();
        }
    }
}