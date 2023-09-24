// Q->https://leetcode.com/problems/largest-number/description/

class Solution { 
    public String largestNumber(int[] nums) {   
            List<String> list = new ArrayList<String>();
    
    for(int i=0;i<nums.length;i++){
        
        list.add(String.valueOf(nums[i]));
    }
    
    Collections.sort(list,new Comparator<>(){
       
        public int compare(String A,String B){
            
            
            String AB = A+B;
            String BA = B+A;
            
            return AB.compareTo(BA) > 0 ? -1 : 1;
        }
        
    });
    
    String res = "";
     for(int i=0;i<list.size();i++){
         res += list.get(i);
    }
    
    if(res.charAt(0) == '0')
        return "0";
    
    return res;

    }

    //another way
    StringBuilder stringBuilder = new StringBuilder();

    Arrays.sort(arr, (String a, String b) -> {
        String ab=a+b;
        String ba=b+a;
        return ab.compareTo(ba) > 0 ? -1 :1;
    });

    for(int i=0;i<arr.length;i++){
        stringBuilder.append(arr[i]);
    }
    if (stringBuilder.length()==0){
        return "0";
    }
    return stringBuilder.toString();
}
