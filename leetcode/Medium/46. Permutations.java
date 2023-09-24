Q->https://leetcode.com/problems/permutations/

class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> list,int[] nums, boolean[] visited){
        if(nums.length == list.size()){
            result.add(new ArrayList(list));
            // list = new ArrayList<>();
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            backtrack(result, list, nums, visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }        
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;        
    }
}