// Q:-> [2, -3, 5, -8, 7] :- Maximum -sum - subset + no adjent elements ocuur

class Set2{
    public static void main(String[] arg){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }

        for(int i=0;i<n;i++){
            System.out.println(dp[i]);
        }
    }
}