// Q->https://leetcode.com/problems/insert-interval/description/
// S->https://leetcode.com/problems/insert-interval/solutions/3056954/c-java-python-short-crisp-approach/
// V->https://www.youtube.com/watch?v=kCfHggU1Sj8
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);
        while (i < n && intervals[i][0] <= newInterval[1]){ 
            int a = Math.min(intervals[i][0], newInterval[0]);
            int b = Math.max(intervals[i][1], newInterval[1]);
            newInterval = new int[] {a, b}; 
            i++;
        }
        res.add(newInterval);
        while (i < n) res.add(intervals[i++]);
        return res.toArray(new int[res.size()][2]);
    }
}
```