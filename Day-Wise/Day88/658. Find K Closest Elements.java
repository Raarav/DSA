// Q->https://leetcode.com/problems/find-k-closest-elements/
// S->(all solution)https://leetcode.com/problems/find-k-closest-elements/solutions/2636647/java-explained-in-detail-binary-search-two-pointers-priority-queue/
// V:->https://www.youtube.com/watch?v=Jv5ZB5EXRFw
// V:-https://www.youtube.com/watch?v=1otAwCQG7XM

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - k;
        while (left < right) {
            int midpoint = left + (right - left) / 2; // same as (left + right) / 2
            if (x - arr[midpoint] > arr[midpoint + k] - x) {
                left = midpoint + 1;
            }
            else {
                right = midpoint;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
