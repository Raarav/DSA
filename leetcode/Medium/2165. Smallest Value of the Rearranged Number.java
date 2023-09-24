// Q->https://leetcode.com/problems/smallest-value-of-the-rearranged-number/

// converstions long into string :- https://www.digitalocean.com/community/tutorials/java-long-to-string

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->
int[] bucket = new int[10];
taking frequency map

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public long smallestNumber(long num) {
        int[] freq = new int[10];
        boolean neg = false;
        if(num < 0) {
            neg = true;
            num = -1 * num; 
        } 
        while(num!=0){
            long val = num%10;
            int index = (int)val;
            freq[index] = freq[index] + 1;
            num /= 10;
        }   
        long result = 0;    
        if(neg){
            int i = 9;
            while(i>=0){
                int fr = freq[i];
                while(fr-->0){
                    if(result == 0){
                        result = i;
                    }else{
                        result *= 10;
                        result += i;
                    }
                }
                i--;
            }
            result *= -1;
        }else{
            for(int i=1;i<10;i++){ 
                if(freq[i]!=0){
                    int fre = freq[i];
                    freq[i] = fre-1;
                    result = i;
                    break;
                }
            }
            int i = 0;
            while(i<10){
                int fr = freq[i];
                while(fr-->0){
                    result *= 10;
                    result += i;
                }
                i++;
            }
        }
        return result; 
    }
}
```