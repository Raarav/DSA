// Q->https://leetcode.com/problems/validate-binary-search-tree/
// S->https://leetcode.c/om/problems/validate-binary-search-tree/discuss/2724888/JAVA-or-DFS-Recursion-or-CLEAN-or-0-ms
// TC: O(n), SC: O(h)

class Solution {
    private boolean recursive(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return recursive(root.left, min, root.val) && recursive(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return recursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}