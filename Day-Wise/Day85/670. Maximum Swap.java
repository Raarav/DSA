// Q->https://leetcode.com/problems/maximum-swap/description/
// V->https://www.youtube.com/watch?v=IiAd7twX0xU

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int maximumSwap(int num) {
        String revStr = "";
        while(num > 0){
            revStr += num%10;
            num /= 10;
        }
        String str = "";
        while(revStr.length()>0){
            str += revStr.charAt(revStr.length()-1);
            revStr = revStr.substring(0, revStr.length()-1);
        }
      
        char[] arr = str.toCharArray();
        int[] lI = new int[10];    
        for(int i=0;i<arr.length;i++){ // prepare last index into array
            lI[arr[i]-'0']=i;
        }    

        // figure out position for swapping
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            int digit = arr[i]-'0';
            for(int j=9;j>digit;j--){
                if(i < lI[j]){
                    // swapping and break
                    swap(arr, i, lI[j]);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        int res = 0;
        for(int i=0;i<arr.length;i++){
            res += (arr[arr.length-i-1] -'0') * (int)Math.pow(10, i);
        }
        return res;
    }
}
```