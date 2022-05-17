// Q->https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/dynamic-queue-official/ojquestion
// Time Complexity = O(n)
// Space Complexity = O(n)

import java.io.*;
import java.util.*;

public class DynamicQueue {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      // write ur code here
      return size;
    }

    void display() {
      // write ur code here
      for(int i = 0; i < size; i++){
        int idx = (front + i) % data.length;
        System.out.print(data[idx] + " ");
      }
      System.out.println();
    }

    // change this code
    void add(int val) {
      // write ur code here
      if(size == data.length){
        int[] twiceArr = new int[2*size];
        int id = 0;
        if(front == 0){
            for(int i=0;i<data.length;i++){
                twiceArr[id] = data[i];
                id++;
            }
        }else{
            for(int i=front;i<data.length;i++){
                twiceArr[id] = data[i];
                id++;
            }
            for(int i=0;i<front;i++){
                twiceArr[id] = data[i];
                id++;
            }
        }
        twiceArr[id] = val;
        data = twiceArr;
        front = 0;
        size++;
      } else {
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
      }
    }

    int remove() {
      // write ur code here
      if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];

        front = (front + 1) % data.length;
        size--;

        return val;
       }
    }

    int peek() {
       // write ur code here
       if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];
        return val;
       }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}