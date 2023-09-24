// Q->https://leetcode.com/problems/powx-n/description/
// S->https://www.youtube.com/watch?v=7t66cSsOPZI

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
    private double solovePos(double x, int n){
        if(n == 0) return 1;
        double val = solovePos(x, n/2);
        if(n%2==0)
            return val*val;
        else
            return x*val*val;
    }
    private double solveMinus(double x, int n){
        if(n == -1) return 1/x;
        double val = solveMinus(x, n/2);
        if(n%2==0)
            return val*val;
        else
            return (1/x)*val*val;
    }
    public double myPow(double x, int n) {
        if(n >= 0)
            return solovePos(x,n);
        else
            return solveMinus(x, n);
    }
}
```