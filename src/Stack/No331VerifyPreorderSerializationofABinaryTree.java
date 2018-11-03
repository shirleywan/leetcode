package Stack;

import java.util.Stack;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 *
 * Example 1:
 *      Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 *      Output: true
 * Example 2:
 *      Input: "1,#"
 *      Output: false
 * Example 3:
 *      Input: "9,#,#,1"
 *      Output: false
 * Example 4: -- hard item
 *      Input: "1,#,#,#,#"
 *      Output: false
 */
class Solution331 {
    /**
     *idea : 遇到两个#，则该节点是叶子节点，那么弹出该节点后压入#，即可
     */
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){return false;}
        if(preorder.length() == 1 && preorder.equals("#")){return true;}
        String[] string = preorder.split(",");
        if(string[0].equals("#")){return false;}
        Stack<String> stack = new Stack<String>();
        int count = 0;
        for(String s : string){
            stack.push(s);
            while(!stack.isEmpty()) {
//                System.out.println(stack.toString());
                String str = stack.pop();
                if(!stack.isEmpty()) {
                    if (str.equals("#") && stack.peek().equals("#")) {
                        if(!stack.isEmpty()){stack.pop();}
                        else{return false;}
                        if(!stack.isEmpty()){stack.pop();}
                        else{return false;}
                        stack.push("#");
                    } else {
                        stack.push(str);
                        break;
                    }
                }
                else {stack.push(str);break;}
            }
        }
        if(stack.pop().equals("#") && stack.isEmpty()){
            return true;
        }
        return false;
    }
}
public class No331VerifyPreorderSerializationofABinaryTree {
    public static void main(String[] args){
        String string = "1,#,#,#,#";
        System.out.println(new Solution331().isValidSerialization(string));
    }
}
