import java.io.*;
import java.util.*;

class n1_Get_subsequence{
    private static ArrayList<String> subSequence(String str){
        if(str.length()==0){
            ArrayList<String> rs = new ArrayList<String>();
            rs.add(" ");
            return rs;
        }
        char ch = str.charAt(0);
        ArrayList<String> subSequences = subSequence(str.substring(1));
        ArrayList<String> result = new ArrayList<String>();
        for(String st : subSequences){
            result.add(st);
        }
        for(String st : subSequences){
            result.add(ch + st);
        }
        return result;
    } 
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> getsubSeq = subSequence(str);
        System.out.print(getsubSeq);
    }    
}