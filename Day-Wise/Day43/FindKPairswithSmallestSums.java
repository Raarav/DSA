// Q->https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k == 0 || (nums1.length == 0 && nums2.length == 0)) return result;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum = nums1[i] + nums2[j];
                if(pq.size() < k) {
                    pq.add(new int[]{nums1[i], nums2[j], sum});
                } else {
                    if(sum < pq.peek()[2]) {
                        pq.poll();
                        pq.add(new int[]{nums1[i], nums2[j], sum});
                    } else break;
                }
            }
        }
                while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            List<Integer> pairList = new ArrayList<>();
            pairList.add(pair[0]);
            pairList.add(pair[1]);
            result.add(0, pairList);
        }
        return result;
    }    
}
