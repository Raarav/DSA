// Q->https://leetcode.com/contest/weekly-contest-323/problems/design-memory-allocator/
// S->https://www.youtube.com/watch?v=ZvSThiksf8c

class Allocator {
    
    int[] arr;
    public Allocator(int n) {
        arr = new int[n];
        Arrays.fill(arr, -1);
    }
    
    public int allocate(int size, int mID) {

        for(int i=0;i<arr.length;i++){
            if(arr[i] == -1){
                int len = 0, j = i;
                while(i<arr.length && arr[i] == -1 && len<size){
                    ++len;
                    ++i;
                }
                
                if(size == len){
                    int ret = j;
                    while(j<i){
                        arr[j++]=mID;
                    }
                    return ret;
                }
            }
        } 
        return -1;
    }
    
    public int free(int mID) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == mID){
                arr[i] = -1;
                count++;
            }                
        } 
        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */