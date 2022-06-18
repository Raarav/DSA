/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    public static int[] printArrayI(int n){
        int[] res = new int[10];
        if(n == 0) {res[0] = 4*(n); return res;}
        res[n-1] = 4*n;
        int[] ans = printArrayI(n-1);
        for(int i=0;i<ans.length;i++){
            if(ans[i]!=0){
                res[i] = ans[i]; 
            }
        }
        // res=ans;
        return res;
    }
    public static int[] printArrayD(int n){
        if(n == 0) return new int[10];
        int[] ans = printArrayD(n-1);
        ans[n-1] = 4*(n);
        return ans;
    }
    public static void printID(int n){
        if(n==0) return;
        System.out.println(n);
        printID(n-1);
        System.out.println(n);
    }
    public static void printD(int n){
        if(n==0) return;
        
        System.out.println(n);
        printD(n-1);
    }
    public static void printI(int n){
        if(n==0) return;
        printI(n-1);
        System.out.println(n);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
// 		printI(5); //printI == print Increasing nos.
// 		printD(5); // printD == print Decreasing nos.
// 		printID(5); // printID == print Increasing Decreasing nos.
        
        int[] arr = printArrayI(10);
        // int[] arr = printArrayD(10);
        for(int val : arr){
            System.out.println(val);
        }
	}
	
}
