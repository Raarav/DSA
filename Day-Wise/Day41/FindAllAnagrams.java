// Q->https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
// TC->O(n)
// SC->O(n)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) return result;      
        // if(s.equals("baa") && p.equals("aa")) {
        //     result.add(1);
        //     return result;
        // }
        HashMap<Character, Integer> shm = new HashMap<>();
        HashMap<Character, Integer> phm = new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            phm.put(ch, phm.getOrDefault(ch, 0) + 1);
        }
        
        for(int i=0;i<p.length();i++){
            char ch = s.charAt(i);
            shm.put(ch, shm.getOrDefault(ch, 0) + 1);
        }
        
        int i=p.length();
        int j = 0;        
        while(i<s.length()){
            System.out.println("shm:-" + shm + "phm:-" + phm);
            if(isAnagram(shm, phm)){ 
                // result.add(i-p.length());
                result.add(j);
            }            
            
            char ch = s.charAt(i);
            shm.put(ch, shm.getOrDefault(ch, 0) + 1);

            // char cha = s.charAt(i - p.length());
            char cha = s.charAt(j);
            if(shm.get(cha) != 1){
                shm.put(cha,shm.get(cha) - 1);
            }else{
                shm.remove(cha);
            }
            i++;
            j++;
        }

        if(isAnagram(shm, phm)){                
            // result.add(i-p.length());
            result.add(j);
        } 
        return result;
    }
    
    public boolean isAnagram(HashMap<Character, Integer> shm, HashMap<Character, Integer> phm){
        boolean result = true;
        for(Map.Entry<Character, Integer> entry : phm.entrySet()){
            if(!shm.containsKey(entry.getKey()) && entry.getValue() != shm.get(entry.getKey())){
                result = false;
                break;
            }
        }
        return result;
    }
}


//effective approch.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> aStart = new ArrayList<Integer>();

        int n = s.length();
        int m = p.length();
        if(m > n) return aStart;
        int []pCount = new int [26];
        int []sCount = new int [26];
        
        for(char c: p.toCharArray()) {
            pCount[c-'a']++;
        }
        for(int i=0; i<n; i++) {
            sCount[s.charAt(i) - 'a']++;
            if(i > m-1) {
                sCount[s.charAt(i-m)-'a']--;
            }
            if(Arrays.equals(pCount, sCount)) {
                aStart.add(i-m+1);
            }
        }
        return aStart;
    }
}