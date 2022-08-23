// Q->https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
// TC->O(n)
// SC->O(n)

import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxLen = 0, sum = 0;
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            sum += val;
            if(hm.containsKey(sum)){
                int diff = i - hm.get(sum);
                maxLen = maxLen < diff ? diff : maxLen;
            }else{
                hm.put(sum, i);
            }
        }
		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
