// Q->https://leetcode.com/problems/shuffle-an-array/description/
// S->https://www.youtube.com/watch?v=NhVMsP9ibuE
// S->https://leetcode.com/problems/shuffle-an-array/solutions/127672/shuffle-an-array/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Uses Ramdom function and swaping

# Approach
<!-- Describe your approach to solving the problem. -->
- Get random number from ramdom function from 0 to n
- and swap by last element

# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    int[] orignal;
    public Solution(int[] nums) {
        orignal = nums;
    }
    
    public int[] reset() {
        return orignal;
    }
    
    public int[] shuffle() {
        int n = orignal.length;
        int[] shuffle = new int[n];
        for(int i=0;i<n;i++){
            shuffle[i]=orignal[i];
        }
        while(--n>0){
            int idx = (int)(Math.random()*(n+1));   /// random fucntion return random value from 0 to n-1 if max is n.
            int temp = shuffle[n];
            shuffle[n] = shuffle[idx];
            shuffle[idx] = temp;
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
```


// Approach #2 Fisher-Yates Algorithm
class Solution {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}