// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/pairs-with-equal-sum-official/ojquestion

import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        // write your code here
        // HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int val = arr[i]+arr[j];
                if(set.contains(val)){
                    return true;
                }else{
                    set.add(val);
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
