// Q->https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/group-shifted-string-official/ojquestion

import java.util.*;

public class Main {
    
    public static String generateKey(String str){
        String result = "";
        if(str.length()==0 || str.length()==1) return "";
        int i=1;
        while(i<str.length()){
            char ch1 = str.charAt(i-1);
            char ch2 = str.charAt(i);
            int val = ch2 - ch1;
            result += val < 0 ? val + 26 : val;
            result += '#';
            i++;
        }
        return result;
    }

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(strs.length==0) return result;
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        for(String str : strs){
            ArrayList<String> list = new ArrayList<>();
            String key = generateKey(str);
            if(hm.containsKey(key)){
                list = hm.get(key);
                list.add(str);
                hm.put(key, list);
            }else{
                list.add(str);
                hm.put(key, list);
            }
        }
        
        for(ArrayList<String> subResult : hm.values()){
            result.add(subResult);
        }
        return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
