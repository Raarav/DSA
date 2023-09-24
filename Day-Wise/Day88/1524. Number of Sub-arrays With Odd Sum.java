// Q->https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/
// V->https://www.youtube.com/watch?v=svvIB5pPc2E
//odd-even=odd
//even-odd=odd
class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans=0;
        int even=0;
        int odd=0;
        
        long sum=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
            if(sum%2==0){
                ans+=odd;
                even++;
            }else{
                ans+=even+1;
                odd++;
            }
        }
        
        return (int)(ans%(1000000007));
    }
}

//mine gives TLE
// class Solution {
//     public int numOfSubarrays(int[] arr) {
//         int n = arr.length;
//         int[] left = new int[n]; // left sum
//         int[] right = new int[n]; // right sum
//         int s = 0;
//         int tes = 0; // tes == totalElementSum
//         while(s<n){
//             left[s] = s-1 < 0 ? arr[s] : arr[s] + left[s-1];
//             right[n-1-s] = n-1-s == n-1 ? arr[n-1-s] : arr[n-1-s] + right[n-1-s+1];
//             tes += arr[s];
//             s++;
//         }
//         ArrayList<Integer> al = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if(i-1<0){
//                     al.add(tes - (j+1 == n ? 0 : right[j+1]));
//                 }else {
//                     al.add(tes - (left[i-1] + (j+1 == n ? 0 : right[j+1])));
//                 }                                
//             }
//         } 
//         int count = 0;
//         for(int i=0;i<al.size();i++){
//             if(al.get(i)%2==1) count++;
//         }   
//         // System.out.println(count);  
//         return (int)(count%(1000000007));
//     }
// }