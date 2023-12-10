// Q->https://leetcode.com/contest/weekly-contest-366/problems/minimum-processing-time/

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks);
        Collections.sort(processorTime);
        int size = tasks.size() / processorTime.size();
        int max = 0;
        
        int loop = 0;
        for(int i=processorTime.size()-1;i>=0;i--){    
            int j=0;
            for(;j<size;j++){
                 max = Math.max(max, tasks.get(loop + j)+processorTime.get(i));
            }      
            loop += size;
        }
        return max;
    }
}