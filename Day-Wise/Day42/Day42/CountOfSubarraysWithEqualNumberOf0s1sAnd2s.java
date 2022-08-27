// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-subarrays-with-equal-number-of-0s-1s-and-2s-official/ojquestion

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        if(arr.length == 0) return 0;
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);
        int ans = 0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                zeroes++;
            }else if(arr[i] == 1){
                ones++;
            }else{
                twos++;
            }
            String key = (zeroes - ones) + "#" + (ones - twos);
            if(map.containsKey(key)){
                int val = map.get(key);
                map.put(key, val + 1);
                ans += val;
            }else{
                map.put(key, 1);
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
