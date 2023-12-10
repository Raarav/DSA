// Q->https://leetcode.com/contest/weekly-contest-372/problems/separate-black-and-white-balls/

class Solution {
    public long minimumSteps(String s) {
        long count = 0;
        int zi = 0; // zero index
        int i=0;
        while(i<s.length()){
            if(s.charAt(i) == '0'){
                if(i!=zi){
                    count += i - zi;                    
                }zi++;
            }
            i++;
        }
        return count;
    }
}