// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/top-view-of-a-binarytree/ojquestion#
// TC-> O(n)
// SC->O(n)
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
    
    // public static class TopViewComparator implements Comparator<QueueObj>{
    //     public int compare(QueueObj t1, QueueObj t2){
    //         return t1.level - t2.level;
    //     }
    // }
    
    public static class QueueObj{
        int level;
        TreeNode node;
        public QueueObj(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
          

     public static ArrayList<Integer> TopView(TreeNode root) {
        // TopViewComparator comparator = new TopViewComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Queue<QueueObj> q1 = new LinkedList<QueueObj>();
        Queue<QueueObj> q2 = new LinkedList<QueueObj>();
        q1.add(new QueueObj(0, root));
        hm.put(0,root.val);
        while(q1.size() > 0){
            int size = q1.size();
            while(size-- > 0){
                QueueObj ln = q1.remove(); // level with node
                TreeNode node = ln.node;
                int lvl = ln.level;
                if(!hm.containsKey(lvl)){
                    hm.put(lvl, node.val);
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
        ArrayList<Integer> res = new ArrayList<Integer>();
        // System.out.println(hm);
        for(int key : hm.keySet()){
            pq.add(key);
        }
        // System.out.println(pq);
        int psize = pq.size();
        for(int i=0;i<psize;i++){
            int p = pq.poll();
            // System.out.println("->"+ p);
            res.add(hm.get(p));
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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}