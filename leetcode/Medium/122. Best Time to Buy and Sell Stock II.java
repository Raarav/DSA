// Q->https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// S->https://www.youtube.com/watch?v=K8iHi8AW1ls

class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=1;i<prices.length;i++){
            int dif = prices[i] - prices[i-1];
            if(dif>0) sum += dif;
        } 
        return sum;       
    }
}