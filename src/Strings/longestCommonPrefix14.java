package Strings;

public class longestCommonPrefix14 {
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0) {return "";}
		String str=strs[0];
		int count=0;
		for(int i=0 ; i<strs.length ; i++) {
			count=str.length();
			while(!strs[i].startsWith(str)) {
				str = str.substring(0, count-1);
				count--;
			}
		}
        return str;
    }
	public static void main(String[] args) {
		String[] string= {};
		System.out.println(longestCommonPrefix(string));
	}
}
