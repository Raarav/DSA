// Q->https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// aonther solution -> S->https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue

class Solution {
    static String[] words = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        return recur(digits);
    }
    private List<String> recur(String digits){
        if(digits.length()==0){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }        
        char ch = digits.charAt(0);
        List<String> ans = recur(digits.substring(1));
        List<String> result = new ArrayList<>();
        String str = words[ch-'0'];
        for(int i=0;i<str.length();i++){
            char ch1 = str.charAt(i);
            for(int j=0;j<ans.size();j++){
                result.add(ch1 + ans.get(j));
            }
        }
        return result;
    }
}