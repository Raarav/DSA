// Q->https://leetcode.com/problems/subsets/

class Solution {
    private List<List<Integer>> recursion(int[] nums, int n){
        if(nums.length == n) {
            List<List<Integer>> al = new ArrayList<>();
            al.add(new ArrayList<>());
            return al;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> list = recursion(nums, n+1);
        for(int i=0;i<list.size();i++){
            List<Integer> sublist = new ArrayList<>();
            for(int j=0;j<list.get(i).size();j++){
                sublist.add(list.get(i).get(j));
            }
            result.add(sublist);                 
        }     
        for(int i=0;i<list.size();i++){
            List<Integer> sublist = new ArrayList<>();
            for(int j=0;j<list.get(i).size();j++){
                sublist.add(list.get(i).get(j));
            }
            sublist.add(nums[n]);         
            result.add(sublist);           
        }
        return result;
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        return recursion(nums, 0);
    }
}