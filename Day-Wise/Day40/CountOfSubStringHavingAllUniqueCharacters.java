// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-all-unique-characters-official/ojquestion
// TC->O(n)
// SC->O(n)
// geek:- https://www.geeksforgeeks.org/count-of-substrings-having-all-distinct-characters/


import java.util.*;

public class Main {

  public static int solution(String str) {
    // write your code here
    if (str.length() == 0) {
      return 0;
    } else {
      int i = 0, j = 0, count = 0;
      HashSet<Character> hs = new HashSet<Character>();
      while (i < str.length()) {

        char ch = j<str.length() ? str.charAt(j) : 0;
        if (j==str.length() || hs.contains(ch)) {
          i++;
          j = i;
          hs = new HashSet<Character>();
        } else {
          hs.add(ch);
          count++;
        //   System.out.println(str.substring(i, j + 1));
          j++;
        }

      }
      return count;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

}
