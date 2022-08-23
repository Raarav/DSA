// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/smallest-substring-of-a-string-containing-all-characters-of-another-string-official/ojquestion#

import java.util.*;

public class Main {

	public static String solution(String s1, String s2){
		// write your code here
		String result = "";
		HashMap<Character, Integer> map2 = new HashMap<>();
		char[] chAr = s2.toCharArray();
		for(char ch: chAr){
		    map2.put(ch, map2.getOrDefault(ch, 0)+1);
		}
		int i=-1,j=-1,mc=0,dmc=s2.length(); //mc = matchCount, dmc=desire match count
		HashMap<Character, Integer> map1 = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(i < s1.length() - 1 && mc < dmc){
                i++;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                
                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
                    mc++;
                }
                f1 = true;
            }
            
            while(j < i && mc == dmc){
                String pans = s1.substring(j + 1, i + 1);
                if(result.length() == 0 || pans.length() < result.length()){
                    result = pans;
                }
                j++;
                char ch = s1.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                
                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
                    mc--;
                }
                f2=true;
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
		return result;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
