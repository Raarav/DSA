// Q->https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/description/
// S->https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/solutions/1567314/java-simple-clean-solution-bit-manipulation-hashmap-60ms-tc-o-nl-p-sc-o-n/
// V->https://www.youtube.com/watch?v=9jV0CC_C26s
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        if (words == null || puzzles == null) {
            throw new IllegalArgumentException("Input is invalid");
        }

        int puzzlesLen = puzzles.length;
        List<Integer> result = new ArrayList<>(puzzlesLen);
        if (puzzlesLen == 0 || words.length == 0) {
            for (int i = 0; i < puzzlesLen; i++) {
                result.add(0);
            }
            return result;
        }

        // This map will store the count of unique word masks
        HashMap<Integer, Integer> wordMaskCountMap = new HashMap<>();
        for (String word : words) {
            int wordMask = getMask(word, 0);
            wordMaskCountMap.put(wordMask, wordMaskCountMap.getOrDefault(wordMask, 0) + 1);
        }

        for (String puzzle : puzzles) {
            // We will only create subsets of last 6 characters because 1st character needs
            // to be present in all words
            int puzzleMask = getMask(puzzle, 1);
            int firstCharMask = 1 << (puzzle.charAt(0) - 'a');
            int subsetMask = puzzleMask;
            int count = wordMaskCountMap.getOrDefault(firstCharMask, 0);

            while (subsetMask != 0) {
                // Check if the (puzzle subset + first character) is present in the
                // wordMaskCountMap map and add its count.
                count += wordMaskCountMap.getOrDefault(subsetMask | firstCharMask, 0);

                // Get next subset of the puzzle.
                subsetMask = (subsetMask - 1) & puzzleMask;
            }

            result.add(count);
        }

        return result;
    }

    // In this function, we are generating a bit mask of each String.
    // Here we set 0th bit for 'a', 1st bit for 'b', and so on.
    // We will be setting upto 26 bits only.
    private static int getMask(String s, int start) {
        int mask = 0;
        for (int i = start; i < s.length(); i++) {
            mask |= 1 << (s.charAt(i) - 'a');
        }
        return mask;
    }
}
/// TLE
// class Solution {
//     public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//         HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
//         for(int i=0;i<26;i++){
//             map.put((char)('a' + i), new ArrayList<>());
//         }
//         for(String word : words){
//             int mask = 0;
//             for(char ch : word.toCharArray()){
//                 int bit = ch - 'a';
//                 mask = mask | (1 << bit);
//             }
//             HashSet<Character> unique = new HashSet<>();
//             for(char ch : word.toCharArray()){
//                 if(unique.contains(ch)) continue;
//                 unique.add(ch);
//                 map.get(ch).add(mask);
//             }
//         }

//         ArrayList<Integer> res = new ArrayList<>();
//         for(String puzzle: puzzles){
//             int pmask = 0;
//             for(char ch : puzzle.toCharArray()){
//                 int bit = ch - 'a';
//                 pmask = pmask | (1 << bit);
//             }
//             char fch = puzzle.charAt(0);
//             ArrayList<Integer> wordsToCheck = map.get(fch);
//             int count = 0;

//             for(int wmask : wordsToCheck){
//                 if((wmask & pmask) == wmask){
//                     count++; 
//                 }
//             }
//             res.add(count);
//         }
//         return res;
//     }
// }

// mine
// class Solution {
//     public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//         boolean[][] puz = new boolean[puzzles.length][26]; 
//         for(int i=0;i<puzzles.length;i++){
//             String str = puzzles[i];
//             boolean[] s = new boolean[26];
//             int j=0;
//             while(j < str.length()){
//                 int index =  str.charAt(j)-'a';
//                 s[index] = true;
//                 j++;
//             }
//             puz[i] = s;
//         }

//         boolean[][] wor = new boolean[words.length][26]; 
//         for(int i=0;i<words.length;i++){
//             String str = words[i];
//             boolean[] s = new boolean[26];
//             int j=0;
//             while(j < str.length()){
//                 int index =  str.charAt(j)-'a';
//                 s[index] = true;
//                 j++;
//             }
//             wor[i] = s;
//         }

//         List<Integer> result = new ArrayList<>();
//         for(int i=0;i<puzzles.length;i++){
//             int count = 0;
//             boolean[] pu = puz[i];
//             for(int j=0;j<wor.length;j++){
//                 int firstIndex = words[j].charAt(0) - 'a';  
//                 if(pu[firstIndex]){
//                     boolean[] w = wor[j];
//                     boolean isValidWord = true;
//                     for(int k=0;k<w.length;i++){
//                         if(w[k]!=pu[k]) {
//                             isValidWord = false;
//                             break;
//                         }
//                     }         
//                     if(isValidWord) count++;
//                 }else{
//                     break;
//                 }
//             }
//             result.add(count);
//         }
//         return result;
//     }
// }
C