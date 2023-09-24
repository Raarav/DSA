Q->https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution {
    //bucket array
    public static int[] topKFrequent(int[] nums, int k) {
        int size = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        
        List<Integer>[] bucketArray = new ArrayList[size + 1];        
        for(int i=0;i<=size;i++)
            bucketArray[i]=new ArrayList<>();        
        
        for(int key : map.keySet()){
            int value = map.get(key);
            bucketArray[value].add(key);
        }
        int[] result = new int[k];
        int i = size;
        int j = 0;
        while(i>=0){
            if(j==k){
                break;
            }else if(bucketArray[i].size()!=0){
                List<Integer> al = bucketArray[i];
                for(int s=0;s<al.size();s++){
                    result[j++] = al.get(s);
                }                
            }   
            i--;
        }
        return result;
    }
    
    
   //mine 
   // public static int[] topKFrequent(int[] nums, int k) {
   //      Map<Integer,Integer> map = new HashMap<>();
   //      for(int i:nums)
   //          map.put(i,map.getOrDefault(i,0)+1);
   //      PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->{
   //          int c1 = map.get(x);
   //          int c2 = map.get(y);
   //          return c2-c1;});
   //      System.out.println(map.keySet());
   //      pq.addAll(map.keySet());
   //      int[] result = new int[k];
   //      int i=0;
   //      while(!pq.isEmpty() && i<k)
   //          result[i++]=(int) pq.poll();
   //      return result;
   //  }
}