// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/diagonal-order-(anti-clock-wise)-of-a-binarytree/ojquestion#!
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while(q1.size()>0){
            ArrayList<Integer> subRes = new ArrayList<>();
            int size = q1.size();
            while(size-- > 0){
                TreeNode node = q1.removeFirst();
                while(node != null){
                    if(node.right != null) q2.addLast(node.right);
                    subRes.add(node.val);
                    node = node.left;
                }
            }
            res.add(subRes);
            q1 = q2;
            q2 = new LinkedList<TreeNode>();
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

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}