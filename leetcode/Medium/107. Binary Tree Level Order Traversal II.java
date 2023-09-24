// Q->https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int ckt = q.size();
            for(int i=0;i<ckt;i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(list);
        }
         List<List<Integer>> rev = new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--){
            rev.add(result.get(i));
        }
        return rev;
    }
}