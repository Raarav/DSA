Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/maximum-consecutive-ones-i-official/ojquestion
TC->O(n)
SC->O(1)
import java.util.*;

public class Main {
    
    // //mine
    // public static int solution(int[] arr){
    //     // write your code here
    //     int ans = 0;
    //     int i=0,j=0,zero=0;
    //     while(i<arr.length){
    //         if(arr[i]==0){
    //             ans = ans > i - j ? ans : i - j;
    //             if(zero == 1){
    //                 while(arr[j] != 0){
    //                     j++;
    //                 }
    //                 j++;
    //                 zero=1;
    //             }else{
    //                 zero++;
    //             }
    //         }
    //         i++;
    //     }
    //     return ans = ans > i - j ? ans : i - j;
    // }
    
    // pepcoding
    public static int solution(int[] arr){
        // write your code here
        int ans = 0;
        int j=-1,zero=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zero++;
            }
            
            while(zero > 1){
                j++;
                if(arr[j] == 0){
                    zero--;
                }
            }
            
            int len = i-j;
            if(len > ans){
                ans = len;
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
        System.out.println(solution(arr));
	}

}
