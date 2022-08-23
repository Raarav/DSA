// Q->https://leetcode.com/problems/group-anagrams/
// geekforgeek:-https://www.geeksforgeeks.org/group-shifted-string/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length==0) return result;
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        for(String str : strs){
            ArrayList<String> list = new ArrayList<>();
            String key = generateKey(str);
            if(hm.containsKey(key)){
                list = hm.get(key);
                list.add(str);
                hm.put(key, list);
            }else{
                list.add(str);
                hm.put(key, list);
            }
        }
        
        for(ArrayList<String> subResult : hm.values()){
            result.add(subResult);
        }
        return result;
    }
    public static String generateKey(String str){
        String result = "";
        if(str.length()==0) return result;
        int[] arr = new int[26];
        int i = 0;
        while(i<str.length()){
            char ch = str.charAt(i);
            int index = ch - 'a';
            arr[index]++;
            i++;
        }
        for(int j=0;j<arr.length;j++){
            int val = arr[j];
            if(val != 0){
                while(val-->0){
                    char cr = (char)('a' + j);
                    result += cr;
                }
            }
        } 
        return result;
    }
}