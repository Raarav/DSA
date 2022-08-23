//Submited Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-all-subarrays-with-zero-sum-official/ojquestion
// more -> Q->https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/ 
// TC-O(n)
// SC-O(n)
import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0, count = 0;
		for(int i=0;i<arr.length;i++){
		    sum += arr[i];
		    if(hm.containsKey(sum)){
		        int val = hm.get(sum);
		        count += val;
		        hm.put(sum,val+1);
		    }else{
		        hm.put(sum, 1);    
		    }
		}
		return count;
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
