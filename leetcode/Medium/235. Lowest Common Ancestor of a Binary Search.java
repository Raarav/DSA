Q-> https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        
        if((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val))
            return root;
        else if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else 
            return lowestCommonAncestor(root.right, p, q);
    }
}