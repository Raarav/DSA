// Q->https://leetcode.com/problems/remove-stones-to-minimize-the-total/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
PriorityQueue
# Approach
<!-- Describe your approach to solving the problem. -->
PriorityQueue
# Complexity
- Time complexity:O(nlongn)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());    
        for(int val : piles){
            pq.add(val);
        }  
        int val = 0; 
        while(k-->0){
            double poll = pq.poll();
            val = (int)Math.ceil(poll/2);          
            pq.add(val);
        }  
        val = 0; 
        while(pq.size()>0){
            val += pq.poll();            
        }  
        return val; 
    }
}
```