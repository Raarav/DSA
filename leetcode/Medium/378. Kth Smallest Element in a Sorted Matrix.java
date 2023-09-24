// Q->https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// S->https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101/C%2B%2BJavaPython-MaxHeap-MinHeap-Binary-Search-Picture-Explain-Clean-and-Concise

class Solution {
    
    // mine
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length; // For general, the matrix need not be a square
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                maxHeap.offer(matrix[r][c]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
    
    //mine
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] temp = new int[n*n];
        int p=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[p]=matrix[i][j];
                p++;
            }
        }
        Arrays.sort(temp);
        return temp[k-1];
    }
}