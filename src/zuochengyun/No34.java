package zuochengyun;

import zuochengyun.util.Node;
import zuochengyun.util.TreeNode;
import java.util.*;
/**
 * 二叉树的序列化和反序列化
 */

class Solution34 {
    public String serialization(TreeNode root) {
        if (root == null) {return "#!";}
        String string = root.value + "!";
        string += serialization(root.left);
        string += serialization(root.right);
        return string;
    }

    //反序列化使用队列实现
    public TreeNode non_serialize(String string) {
        if (string == "#!") {return null;}
        String[] ch = string.split("!");
        TreeNode[] nodes = new TreeNode[ch.length];
        for (int i =0 ; i < ch.length ; i ++){
            if ( ch[i].equals("#") ) {
                TreeNode node = new TreeNode(Integer.valueOf(ch[i]));
                nodes[ i ] = node;
            }
            else{
                nodes[i] = null;
            }
        }
        TreeNode p = nodes[0];
        for (int i = 1 ; i < nodes.length ; i ++){
            if(nodes[i] != null){p.left = nodes[i];}
        }

    }

}

public class No34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        root.left = n1; root.right = n3;
        n1.right = n2;
        n3.left = n4; n3.right = n5;
        System.out.println(new Solution34().serialization(root));
    }
}
