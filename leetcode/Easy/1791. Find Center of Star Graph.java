Q->1791. Find Center of Star Graph

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->
Map<Integer, ArrayList<Integer>> adjuncy_list = new HashMap<>(); 

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        Map<Integer, ArrayList<Integer>> al = new HashMap<>(); // adjuncy list
        for(int i=0;i<n;i++){
            int[] arr = edges[i];
            int src = arr[0];
            int des = arr[1];
            if(al.containsKey(src)){
                ArrayList<Integer> l = al.get(src);
                l.add(des);
                al.put(src,l);
            }else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(des);
                al.put(src,l);
            }      
            if(al.containsKey(des)){
                ArrayList<Integer> l = al.get(des);
                l.add(src);
                al.put(des,l);
            }else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(src);
                al.put(des,l);
            }       
        }
        for(Map.Entry<Integer, ArrayList<Integer>> it: al.entrySet()){
            if(it.getValue().size() == n) return it.getKey();            
        }
        return -1;
    }
    // MLE due SC:- O(n^2)
    // public int findCenter(int[][] edges) {
    //     int n = edges.length;
    //     boolean[][] visited = new boolean[n+2][n+2];
    //     for(int i=0;i<n;i++){
    //         int[] arr = edges[i];
    //         int src = arr[0];
    //         int des = arr[1];
    //         visited[src][des] = true;
    //         visited[des][src] = true;
    //     }     
        
    //     for(int i=0;i<visited.length;i++){
    //         int count = 0;
    //         for(int j=0;j<visited[0].length;j++){
    //             if(visited[i][j]) count++;
    //         }
    //         System.out.println(count);
    //         if(count == (n)){
    //             return i;
    //         }
    //     }   
    //     return -1;
    // }
}
```