// submitted:- Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/largest-subarray-with-contiguous-elements-official/ojquestion
// Q->https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/#:~:text=If%20all%20elements%20are%20distinct,maximum%20element%20in%20every%20subarray.
// TC->O(N^2)
// SC->O(N)
import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
		int maxLen = 0;	
		
		for(int i=0;i<arr.length-1;i++){
		    int min = arr[i];
		    int max = arr[i];
		    HashSet<Integer> cd = new HashSet<>();
		    cd.add(arr[i]);
		    for(int j=i+1;j<arr.length;j++){
		        if(cd.contains(arr[j])){
		            break;
		        }
		        cd.add(arr[j]);
		        min = Math.min(min, arr[j]);
		        max = Math.max(max, arr[j]);
		        if(max - min == j-i){
		            int len = j - i + 1;
		            if(len > maxLen){
		                maxLen = len;
		            }
		        }
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
