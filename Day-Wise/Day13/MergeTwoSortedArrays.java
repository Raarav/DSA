// Q->https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/merge-two-sorted-arrays-official/ojquestion
// Time complexity -> O(n)
// space complexity -> O(n)

import java.io.*;
import java.util.*;

public class MergeTwoSortedArrays {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //write your code here
    int aSize = a.length;
    int bSize = b.length;
    int totalLength = aSize+bSize;
    int[] result = new int[totalLength];
    
    int i=0;
    int j=0;
    
    for(int k=0;k<totalLength;k++){
        if(i<aSize && j<bSize){
            if(a[i]<b[j]){
                result[k]=a[i];
                i++;
            }else{
                result[k]=b[j];
                j++;
            }
        }else{
            
            if(j>=bSize && i<aSize){
                result[k]=a[i];
                i++;
            }
        
            if(i>=aSize && j<bSize){
                result[k]=b[j];
                j++;
            }
            
        }
        
        
    }
    
    return result;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}