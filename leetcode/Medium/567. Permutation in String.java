Q->https://leetcode.com/problems/permutation-in-string/description/


class Solution {
    private int[] convertIntoArray(String str){
        int[] arr = new int[26];
        int len = str.length();
        for(int i=0;i<len;i++){
            int index = str.charAt(i) - 'a';
            arr[index] += 1;
        }
        return arr;
    }
    private boolean isEqual(int[] arr1, int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] per = convertIntoArray(s1);
        int len = s1.length();
        for(int i=0;(i + len)<= s2.length();i++){
            int[] subString = convertIntoArray(s2.substring(i, i+len));
            if(isEqual(per, subString)) return true;
        }
        return false;
    }

    /// gives TLE
    // private void permutations(String str, List<String> per, String ans){
    //     if(str.length() == 0){
    //         per.add(ans);
    //         return; 
    //     }
    //     else{
    //         for(int i=0;i<str.length();i++){
    //             char ch = str.charAt(i);
    //             permutations(str.substring(0, i) + str.substring(i+1), per, ans + ch);
    //         }
    //     }
    // }
    // public boolean checkInclusion(String s1, String s2) {
    //     List<String> per = new ArrayList<>();
    //     permutations(s1, per, "");
    //     int j=0;
    //     int len = s1.length();
    //     while(j<per.size()){
    //         String str = per.get(j);            
    //         for(int i=0;(i + len)<s2.length();i++){
    //             if(str.equals(s2.substring(i, len))) return true;
    //         }
    //         j++;
    //     }
    //     return false;
    // }
}