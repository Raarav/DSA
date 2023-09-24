Q->https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    
    //HashSet
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums) set.add(val);

        int max = 0;
        for(int val : nums){
            if(set.contains(val-1)) continue;
            else{
                int cur = val;
                int temp = 1;
                while(set.contains(++cur)){
                    temp++;                    
                }
                max = Math.max(max,temp);
            }
        }
        return max;
    }
    
    
    //HashMap
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean>  map = new HashMap<>();
        for(int val : nums){
            map.put(val, true);
        }
        
        for(int val : nums){
            map.put(val, map.containsKey(val-1) ? false : true);
        }

        int max = 0;
        int temp = 1;
        for(Map.Entry<Integer, Boolean> e : map.entrySet()){
            if(e.getValue()){
                int val = e.getKey();
                while(map.containsKey(++val)){
                    temp++;
                }
                max = Math.max(max,temp);
                temp=1;
            }            
        }
        return max;
    }
}