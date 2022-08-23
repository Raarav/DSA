// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/left-view-of-a-binarytree/ojquestion
// TC-> O(n)
// Sc-> O(1)
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

    public static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q1.addLast(root);
        while(q1.size() != 0){
            int size = q1.size();
            TreeNode node = q1.getFirst()
            res.add(node.data);
            while(size-- > 0){
                node = q1.removeFirst();
                if(node.left != null) q2.addLast(node.left);
                if(node.right != null) q2.addLast(node.right);
            }
            q1 = q2;
            q2 = new LinkedList<>();;
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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}