// Q->https://leetcode.com/problems/verbal-arithmetic-puzzle/
// S->https://leetcode.com/problems/verbal-arithmetic-puzzle/solutions/463953/java-fast-backtracking-clean-code-o-n-300ms/


class Solution {
    private static final int[] POW_10 = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};
    public boolean isSolvable(String[] words, String result) {
        Set<Character> charSet = new HashSet<>();
        int[] charCount = new int[91];
        boolean[] nonLeadingZero = new boolean[91]; // ASCII of `A..Z` chars are in range `65..90`
        for (String word : words) {
            char[] cs = word.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (i == 0 && cs.length > 1) nonLeadingZero[cs[i]] = true;
                charSet.add(cs[i]);
                charCount[cs[i]] += POW_10[cs.length - i - 1]; // charCount is calculated by units
            }
        }
        char[] cs = result.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i == 0 && cs.length > 1) nonLeadingZero[cs[i]] = true;
            charSet.add(cs[i]);
            charCount[cs[i]] -= POW_10[cs.length - i - 1]; // charCount is calculated by units
        }
        boolean[] used = new boolean[10];
        char[] charList = new char[charSet.size()];
        int i = 0;
        for (char c : charSet) charList[i++] = c;
        return backtracking(used, charList, nonLeadingZero, 0, 0, charCount);
    }

    private boolean backtracking(boolean[] used, char[] charList, boolean[] nonLeadingZero, int step, int diff, int[] charCount) {
        if (step == charList.length) return diff == 0; // difference between sum of words and result equal to 0
        for (int d = 0; d <= 9; d++) { // each character is decoded as one digit (0 - 9).
            char c = charList[step];
            if (!used[d] // each different characters must map to different digits
                    && (d > 0 || !nonLeadingZero[c])) {  // decoded as one number without leading zeros.
                used[d] = true;
                if (backtracking(used, charList, nonLeadingZero, step + 1, diff + charCount[c] * d, charCount)) return true;
                used[d] = false;
            }
        }
        return false;
    }
}


//mine
class Solution {
    String res;
    String[] dis;
    private boolean isValid(HashMap<Character, Integer> map){
        // System.out.println(map);
        int ans = 0; // calculating word 
        for(int i=0;i<dis.length;i++){
            int digit = 0;
            String s = dis[i];
            for(int j=0;j<s.length();j++){
                char key = s.charAt(s.length()-1-j);
                digit += map.get(key) * Math.pow(10, j);
            }
            // System.out.println(s + ":-" + digit);
            ans += digit;
        }

        int res1 = 0; // calculating result 
        for(int i=0;i<res.length();){
            char key = res.charAt(res.length()-1-i);
            res1 += map.get(key) * Math.pow(10, i);
            i++;
        }
        // System.out.println(res + ":-" + res1);

        return res1 == ans;
    }
    private boolean recursionBacktrack(int n, boolean[] visited, String str, HashMap<Character, Integer> map){
        if(n == str.length()){
            return isValid(map);
        }

        char ch = str.charAt(n);

        for(int i=0;i<10;i++){
            if(!visited[i]){
                visited[i] = true;
                map.put(ch, i);
                if(recursionBacktrack(n+1, visited, str, map)) return true;
                map.put(ch, null);
                visited[i] = false;
            }
        }

        return false;
    }
    public boolean isSolvable(String[] words, String result) {
        dis = words; res = result;
        HashMap<Character, Integer> map = new HashMap<>();
        String str = "";
        boolean[] visited = new boolean[10];
        for(int i=0;i<words.length;i++){
            String st = words[i];
            for(int j=0;j<st.length();j++){
                char ch = st.charAt(j);
                map.put(ch, null);
            }
        }        
        for(int i=0;i<result.length();){
            char ch = result.charAt(i);
            map.put(ch, null);
            i++;
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            str += entry.getKey() + "";
        }                
        return recursionBacktrack(0,visited, str, map);
    }
}