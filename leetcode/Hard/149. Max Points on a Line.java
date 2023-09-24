// Q->https://leetcode.com/problems/max-points-on-a-line/description/
// V->https://www.youtube.com/watch?v=TGRl2dJzL64

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n*n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int maxPoints(int[][] points) {
        int m = points.length;
        int max = 0;
        for(int i=0;i<m;i++){
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=0;j<m;j++){
                if(j!=i){
                    int[] src = points[i];
                    int[] tar = points[j];
                    int nano = tar[1]-src[1];
                    int dano = tar[0]-src[0];

                    String slope = "";
                    if(dano == 0){
                        slope = "infite";
                    }else{
                        double val = (double)nano/dano;
                        // val = val < 0 ? val * -1 : val;
                        slope = val + "";
                    }
                    
                    if(map.containsKey(slope)){
                        map.put(slope, map.get(slope) + 1);
                    }else{
                        map.put(slope, 1);
                    }
                    
                }
            }
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                max = Math.max(max, entry.getValue());
            }            
        }  
        return points.length == 1 ? 1 : max+1; 
    }
}
```