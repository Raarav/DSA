// Q->https://leetcode.com/contest/biweekly-contest-117/problems/distribute-candies-among-children-i/

class Solution {
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for(int i=0;i<=limit;i++){
            for(int j=0;j<=limit;j++){
                for(int k=0;k<=limit;k++){
                    if(i+j+k == n){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}