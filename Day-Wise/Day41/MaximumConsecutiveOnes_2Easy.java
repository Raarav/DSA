// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/maximum-consecutive-ones-ii-official/ojquestion
// TC->O(n)
// SC->O(1)
import java.util.*;

public class Main {

    public static int solution(int[] arr, int k){
        // write your code here
        int j = -1, ans = 0, count = 0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
            }
            
            while(count > k){
                j++;
                if(arr[j]==0){
                    count--;
                }
            }
            
            int len = i - j;
            if(len > ans){
                ans=len;
            }
        }

        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
	}

}
