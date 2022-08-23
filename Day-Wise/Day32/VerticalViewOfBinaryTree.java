Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/vertical-order-traversal-of-a-binarytree/ojquestion
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

    public static class QueueObj{
        int level;
        TreeNode node;
        public QueueObj(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer,LinkedList<Integer>> hm = new HashMap();
        Queue<QueueObj> q1 = new LinkedList<>();
        Queue<QueueObj> q2 = new LinkedList<>();
        q1.add(new QueueObj(0, root));
        LinkedList<Integer> al = new LinkedList<>();
        al.add(root.val);
        hm.put(0, al);
        while(q1.size() > 0){
            int size = q1.size();
            while(size-- > 0){
                QueueObj ln = q1.remove();
                TreeNode node = ln.node;
                int lvl = ln.level;
                if(!hm.containsKey(lvl)){
                    LinkedList<Integer> cl = new LinkedList<>();
                    cl.add(node.val);
                    hm.put(lvl, cl);
                }else{
                    LinkedList<Integer> cl = hm.get(lvl);
                    cl.add(node.val);
                    hm.put(lvl, cl);
                }
                if(node.left != null) {
                    q2.add(new QueueObj(lvl-1, node.left));
                }
                if(node.right != null) {
                    q2.add(new QueueObj(lvl+1, node.right));
                }
            }
            q1 = q2;
            q2 = new LinkedList<QueueObj>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        // System.out.println(hm);
        for(int key : hm.keySet()){
            pq.add(key);
        }
        int psize = pq.size();
        for(int i=0;i<psize;i++){
            int p = pq.poll();
            LinkedList<Integer> s = s = hm.get(p);
            if(p == 0){
                s.removeFirst();
            } 
            // int s = size();
            ArrayList<Integer> sl = new ArrayList<>();
            while(s.size() > 0){
                sl.add(s.removeFirst());
            }
            res.add(sl);
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
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