package leetcode;

/**
 * word-break-ii
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
import java.util.*;
class Solution11{
    /**
     *method 1：算法复杂度太大，要想新办法
     */
    public ArrayList<String> wordBreak1(String s, Set<String> dict) {
        if(s.length()== 0 || dict.isEmpty()){return new ArrayList<String>();}
        ArrayList<String> totallist = new ArrayList<String>();
        int n = 0;
        String newstr = "";
        String getstr = "";
        if(totallist.size() == 0){
            for (String str : dict) {
                if (str.charAt(0) == s.charAt(0)) {
                    if (isMatch(str, s)) {
                        newstr = str;
                        totallist.add(newstr);
//                        s = s.replaceFirst(str, "");
                    }
                }
            }
        }
        while(!allEqual(s , totallist)) {
            for (int p = 0; p < totallist.size(); p++) {
                newstr = "";
                getstr = totallist.get(p);
                for(String substr : getstr.split(" ")){
                    newstr = newstr + substr;
                }
                for(String str:dict){
                    if(s.contains(newstr + str)){ totallist.add(getstr+" "+str);}
                }
                totallist.remove(getstr);
            }
        }
        return totallist;
    }
    public boolean isMatch(String s , String string){
        if(s.length() ==0 || string.length() ==0){return false;}
        int n = s.length();
        for(int i = 0; i<n; i++){
            if(s.charAt(i) != string.charAt(i)) return false;
        }
        return true;
    }
    public boolean allEqual(String str , ArrayList<String> list){
        if(str.length() == 0 || list.size() <= 0){return false;}
        String newstr = "";
        for(String string : list){
            newstr = "";
            for(String substr : string.split(" ")){
                newstr = newstr + substr;
            }
            if(!str.equals(newstr)){return false;}
        }
        return true;
    }

    /**
     * method 2 ：复杂度有些大，暴力求解
     */
    public ArrayList<String> wordBreak2(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        helper(s,dict,0,"",res);
        return res;
    }
    private void helper2(String s, Set<String> dict, int start, String item, ArrayList<String> res)
    {
        if(start>=s.length())
        {
            res.add(item);
            return;
        }
        StringBuilder str = new StringBuilder();
        for(int i=start;i<s.length();i++)
        {
            str.append(s.charAt(i));
            if(dict.contains(str.toString()))
            {
                String newItem = item.length()>0?(item+" "+str.toString()):str.toString();
                helper(s,dict,i+1,newItem,res);
            }
        }
    }
    /**
     *method 3：动态规划
     */
    public boolean wordBreakcheck(String s, Set<String> dict) {
        if(s==null || s.length()==0)
            return true;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++){
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++){
                if(res[j] && dict.contains(str.toString())){
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        if(wordBreakcheck(s,dict))
            helper(s,dict,0,"",res);
        return res;
    }
    private void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res){
        if(start>=s.length()){
            res.add(item);
            return;
        }

        StringBuilder str = new StringBuilder();
        for(int i=start;i<s.length();i++){
            str.append(s.charAt(i));
            if(dict.contains(str.toString())){
                String newItem = new String();
                if(item.length()>0)
                    newItem = item + " " + str.toString();
                else
                    newItem = str.toString();
                helper(s,dict,i+1,newItem,res);
            }
        }
    }
}
public class No11 {
    public static void main(String[] args){
        String s ="catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
        System.out.println(new Solution11().wordBreak(s,dict));
    }
}
