// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-subarrays-with-equal-number-of-zeroes-and-ones-official/ojquestion

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        if(arr.length == 0) return 0;
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                sum += -1;
            }else{
                sum += 1;
            }
            if(map.containsKey(sum)){
                int val = map.get(sum);
                ans += val;
                map.put(sum, val + 1);
                
            }else{
                map.put(sum, 1);
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
        System.out.println(solution(arr));
    }

}
