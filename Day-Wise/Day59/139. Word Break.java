// Q->https://leetcode.com/problems/word-break/description/
// V->https://www.youtube.com/watch?v=LPs6Qo5qlJM

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
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;

        if(map.containsKey(s)) return map.get(s);

        for(int i=1;i<=s.length();i++){
            String left = s.substring(0,i);
            if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict)){
                map.put(left, true);
                return true;
            } 
        }

        map.put(s, false);

        return false;        
    }
}
//mine 
// class Solution {
//     HashSet<String> set = new HashSet<>();
//     private boolean recursionBacktrack(String s){
//         if(s.length() == 0) return true;

//         for(int i=0;i<s.length();i++){
//             String str = s.substring(0,i+1);
//             if(set.contains(str)) 
//                 if(recursionBacktrack(s.substring(i+1)))
//                     return true;
//         }

//         return false;
//     }
//     public boolean wordBreak(String s, List<String> wordDict) {
//         for(int i=0;i<wordDict.size();i++){
//             set.add(wordDict.get(i));
//         }
//         return recursionBacktrack(s);        
//     }
// }
```