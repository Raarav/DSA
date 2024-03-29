// Q->https://leetcode.com/problems/sum-of-left-leaves/

class Solution {
    public int sumOfLeftLeaves(TreeNode r) { 
        if (r == null) return 0;
        int sum = 0;
        if (r.left != null && r.left.left == null && r.left.right == null) sum += r.left.val;
        return sum + sumOfLeftLeaves(r.left) +sumOfLeftLeaves(r.right);
    }
 
}