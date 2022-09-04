// Q->https://leetcode.com/problems/powerful-integers/
// TC->O(n^2)
// SC->O(1)
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> py = new ArrayList<>();
        List<Integer> px = new ArrayList<>();
        int powx = x, powy = y;
        py.add(1);
        px.add(1);
        
        if(x != 1){
            while(powx < bound){
                px.add(powx);
                powx = powx * x;
            }
        }
        
        if(y != 1){
            while(powy < bound){
                py.add(powy);
                powy = powy * y;
            }
        }
        
        Set<Integer> result = new HashSet<>();
        
        for(int i : px){
            for(int j : py){
                int sum = i + j;
                if(sum <=  bound) result.add(sum);
            }
        }
        
        return result.stream().collect(Collectors.toList());
    }
}