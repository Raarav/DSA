Q->https://leetcode.com/problems/balanced-binary-tree/
S->https://leetcode.com/problems/balanced-binary-tree/solutions/3093444/java-c-100-solution-using-depth-first-search-balanced-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans = true;
    private int solve(TreeNode node){
        if(node == null) return 0;

        int left = solve(node.left);
        int right = solve(node.right);

        if(Math.abs(left - right) > 1) {
            ans = false;
        } 

        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        solve(root);   
        return ans;
    }
}