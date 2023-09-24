// Q->https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// S->https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63783/Two-Easiest-In-Order-Traverse-(Java)

class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;
        
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p=p.left;
            }else{
                TreeNode node = stack.pop();
                if(++count == k) return node.val;
                p = node.right;
            }
        }
        return -1;
    }
    
    //mine
//     int count = 0;
//     int result = 0;
//     public int kthSmallest(TreeNode root, int k) {
//         recur(root, k);
//         return result;
//     }
    
//     public void recur(TreeNode root, int k){
//         if(root.left != null){
//             recur(root.left, k);
//         }        
//         count++;
//         if(count == k){
//             result = root.val;
//             return;
//         }
//         if(root.right != null){
//             recur(root.right, k);
//         }
//     }
}