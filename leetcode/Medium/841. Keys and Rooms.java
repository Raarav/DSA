// Q->https://leetcode.com/problems/keys-and-rooms/
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
    private void DFS(boolean[] visited, int n, List<List<Integer>> rooms){
        if(visited[n]) return;
        visited[n] = true;
        List<Integer> ls = rooms.get(n);
        for(int i=0;i<ls.size();i++){
            int jump = ls.get(i);
            DFS(visited, jump, rooms);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        DFS(visited, 0, rooms);
        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}
```