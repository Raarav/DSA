// Q->https://leetcode.com/problems/insert-delete-getrandom-o1/post-solution/?submissionId=859382756
// V->https://www.youtube.com/watch?v=qO_EkdJPf2Y

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(1)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
public class RandomizedSet {
    HashSet<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = new Random().nextInt(set.size());
        for (int num : set) {
            if (index == 0) return num;
            index--;
        }
        return -1;
    }
}
```