// Q->https://leetcode.com/problems/possible-bipartition/description/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
coloring approch
# Approach
<!-- Describe your approach to solving the problem. -->
DFS.
# Complexity
- Time complexity:O(N+E)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(N)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N+1];
            List<Integer>[] graph = new List[N+1];
            for(int i=0;i<=N;i++){
                graph[i] = new ArrayList<>();
            }

            for(int[] v: dislikes){
                graph[v[0]].add(v[1]);
                graph[v[1]].add(v[0]);
            }

            for(int i=1;i<=N;i++){
                if(color[i] == 0){
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    color[i] = 1;
                    while(queue.size() != 0){
                        int top = queue.removeFirst();
                        for(int nbr : graph[top]){
                            if(color[nbr] == color[top]) return false;
                            if(color[nbr] == 0){
                                color[nbr] = -color[top];
                                queue.add(nbr);
                            }
                        }
                    }
                }
            }
            return true;
    }
}
```