// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-sum-divisible-by-k-official/ojquestion
import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        if(arr.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                int len = i - idx;
                if(len > ans){
                    ans = len;
                }
            }else{
                map.put(rem, i);
            }
            
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
