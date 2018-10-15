package Strings;

import java.util.ArrayList;
import java.util.*;

/**
 * 71. Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 *      path = "/home/", => "/home"
 *      path = "/a/./b/../../c/", => "/c"
 *      path = "/a/../../b/../c//.//", => "/c"
 *      path = "/a//b////c/d//././/..", => "/a/b/c"
 *
 * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
 *
 * Corner Cases:
 *      Did you consider the case where path = "/../"?
 *      In this case, you should return "/".
 *      Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 *      In this case, you should ignore redundant slashes and return "/home/foo".
 */
class Solution71 {
    public String simplifyPath(String path) {
        if(path.length() == 0){return "";}
//        if(path.length() == 1 && path == "/") {return "";}
        List<String> list = new ArrayList<String>();
        for(String string : path.split("/")){
            if(string.equals("") || string.equals(".")){
                continue;
            }
            else{
                if(string.equals("..")){
                    if(!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                }
                else{
                    list.add(string);
                }
            }
        }
//        if(list.isEmpty()){return "/";}
        return "/"+listToString(list , '/');
    }
    public String listToString(List list, char separator) {
        if(list.isEmpty()){return "";}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }
}
public class No71SimplifyPath {
    public static void main(String[] args){
        String path = "/";
        System.out.println(new Solution71().simplifyPath(path));
    }
}
