// Q->https://leetcode.com/problems/merge-intervals/
// S->https://www.youtube.com/watch?v=_FkR5zMwHQ0\

// Array.sort():- https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
// Integer.sort():- https://www.geeksforgeeks.org/java-integer-compare-method/

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0])); // array sorted through lemda function
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            if(list.size() == 0){
                list.add(interval);
            }else{
                int preInterval[] = list.get(list.size()-1);
                if(interval[0] <= preInterval[1]){
                    preInterval[1] = Math.max(preInterval[1],interval[1]);                             
                }else{
                    list.add(interval);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}