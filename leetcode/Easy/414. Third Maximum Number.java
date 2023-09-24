Q->https://leetcode.com/problems/third-maximum-number/

class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int v :  nums){
            set.add(v);
        }
        PriorityQueue <Integer> heap=new PriorityQueue<>(Collections.reverseOrder());        
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            heap.add(it.next());
        }
        if(heap.size()<3) return heap.poll();
        else{
            int _3rd = nums[0];
            for (int i = 0; i < 3 ; i++) {
                Integer max = heap.poll();
                _3rd = max == null ? _3rd : max;
            }
            return _3rd;            
        }        
    }
}