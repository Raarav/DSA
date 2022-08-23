// Q->https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
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
    while (q1.size() != 0) {
      int size = q1.size();
      TreeNode node = q1.getFirst();
      res.add(node.data);
      while (size-- > 0) {
        node = q1.removeFirst();
        if (node.left != null) q2.addLast(node.left);
        if (node.right != null) q2.addLast(node.right);
      }
      q1 = q2;
      q2 = new LinkedList<>();;
    }
    return res;
  }

  public static ArrayList<Integer> rightView(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    Queue<TreeNode> q1 = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();
    q2.add(root);
    while (q2.size() > 0) {
      TreeNode node = q2.peek();
      int size = q2.size();
      res.add(node.data);
      while (size-- > 0) {
        node = q2.remove();
        if (node.right != null) q1.add(node.right);
        if (node.left != null) q1.add(node.left);

      }
      q2 = q1;
    }
    return res;
  }

  public static class QueueObj {
    int level;
    TreeNode node;
    public QueueObj(int level, TreeNode node) {
      this.level = level;
      this.node = node;
    }
  }

  public static ArrayList<Integer> BottomView(TreeNode root) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    HashMap<Integer, LinkedList<Integer>> hm = new HashMap();
    Queue<QueueObj> q1 = new LinkedList<>();
    Queue<QueueObj> q2 = new LinkedList<>();
    q1.add(new QueueObj(0, root));
    LinkedList<Integer> al = new LinkedList<>();
    al.add(root.data);
    hm.put(0, al);
    while (q1.size() > 0) {
      int size = q1.size();
      while (size-- > 0) {
        QueueObj ln = q1.remove();
        TreeNode node = ln.node;
        int lvl = ln.level;
        if (!hm.containsKey(lvl)) {
          LinkedList cl = new LinkedList<>();
          cl.add(node.data);
          hm.put(lvl, cl);
        } else {
          LinkedList cl = hm.get(lvl);
          cl.add(node.data);
          hm.put(lvl, cl);
        }
        if (node.left != null) {
          q2.add(new QueueObj(lvl - 1, node.left));
        }
        if (node.right != null) {
          q2.add(new QueueObj(lvl + 1, node.right));
        }
      }
      q1 = q2;
      q2 = new LinkedList<QueueObj>();
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    // System.out.println(hm);
    for (int key : hm.keySet()) {
      pq.add(key);
    }
    int psize = pq.size();
    for (int i = 0; i < psize; i++) {
      int p = pq.poll();
      LinkedList<Integer> s = hm.get(p);
      res.add(s.getLast());
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
    
    ArrayList<Integer> boundies = new ArrayList<>();
    ArrayList<Integer> ans = leftView(root);
    ans.remove(ans.size()-1);
    for (Integer i : ans) boundies.add(i);
    
    ArrayList<Integer> ans2 = BottomView(root);
    for (int i=1;i<ans2.size()-1;i++){
        boundies.add(ans2.get(i));
    }

    ArrayList<Integer> ans1 = rightView(root);
    for (int i=ans1.size()-2;i>0;i--){
        boundies.add(ans1.get(i));
    }
    
    // for (int i=1;i<ans2.size()-1;i++){
    //     boundies.add(ans1.get(i));
    // }
    System.out.println(boundies);
  }

  public static void main(String[] args) {
    solve();
  }
}