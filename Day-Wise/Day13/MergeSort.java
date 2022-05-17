// Q-> https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/merge-sort-official/ojquestion
// Time complexity -> O(nlogn)
// space complexity -> O(n)

import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeSort(int[] arr, int lo, int hi) {
    //write your code here
    
    if(lo==hi){
        int[] base = new int[1];
        base[0] = arr[lo];
        return base;
    }
    
    int mid = (lo + hi)/2;
    int[] leftArr = mergeSort(arr,lo,mid);
    int[] rightArr = mergeSort(arr,mid+1,hi);
    int[] result = mergeTwoSortedArrays(leftArr, rightArr);

    return result;
  }

  //used for merging two sorted arrays
  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    System.out.println("Merging these two arrays ");
    System.out.print("left array -> ");
    print(a);
    System.out.print("right array -> ");
    print(b);
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

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int[] sa = mergeSort(arr,0,arr.length - 1);
    System.out.print("Sorted Array -> ");
    print(sa);
  }

}