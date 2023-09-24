// Q->https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
// S->https://leetcode.com/problems/minimum-index-sum-of-two-lists/solutions/103654/java-o-n-m-time-o-n-space/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        int li = Integer.MAX_VALUE; // least index
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<list2.length;i++){
            map.put(list2[i], i);
        }        

        for(int i=0;i<list1.length;i++){
            String key = list1[i];
            Integer j = map.get(key);
            if(j!=null && (i+j) < li){
                li=i+j;
                res = new ArrayList<>();
                res.add(key);
            }else if(j!=null && i+j == li){
                res.add(key);
            }
        }
        String[] result = new String[res.size()];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        } 
        return result;
    }
}