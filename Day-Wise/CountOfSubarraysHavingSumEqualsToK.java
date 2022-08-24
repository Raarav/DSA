// https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    public int subarraySum(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum == k){
                count += 1;
            }
            int csum = sum;
            for(int j=0;j<i;j++){
                csum -= arr[j];
                if(csum == k){
                    count += 1;
                }                              
            }
        }
        return count;
    }
}
/// effective solution
class Solution {
    public int subarraySum(int[] arr, int k) {
        if(arr.length == 0) return 0;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0,1);
        int sum = 0;
        
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(hm.containsKey(sum - k)){
                ans += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum,0) + 1);
        }
        return ans;
    }
}