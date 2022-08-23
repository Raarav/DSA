// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/right-view-of-a-binarytree/ojquestion
// TC->O(n)
// SC->O(n)
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int data = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.data = val;
        }
    }

    public static ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root);
        while(q2.size() > 0){
            TreeNode node = q2.peek();
            int size = q2.size();
            res.add(node.data);
            while(size-- > 0){
                node = q2.remove();
                if(node.right != null) q1.add(node.right);
                if(node.left != null) q1.add(node.left);

            }
            q2 = q1;
        }
        return res;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<Integer> ans = rightView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}