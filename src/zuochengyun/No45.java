package zuochengyun;

/**
 * 根据后序数组重建搜索二叉树 -- unfinished
 */
import zuochengyun.util.TreeNode;

import java.util.*;
class Solution45{
    public TreeNode backTree(ArrayList<Integer> list){
        if(list.size() == 0){return null;}
        if(list.size() == 1){TreeNode node = new TreeNode(list.get(0)); return node;}
        int[] nums = new int[list.size()];
        for(int i = 0 ; i <nums.length ; i++){
            nums[i] = list.get(i);
        }
        TreeNode root = new TreeNode(nums[nums.length-1]);
        return root;
    }
    public boolean findNext(int[] nums , int begin , int end){
        if(begin == end){return true;}
        int less = -1  ;
        int more = end ;
        for( int i = begin ; i < end ; i ++){
            if(nums[end] > nums[i] ){
                less = 1;
            }
            else{
                more = more == end ? i : more;
            }
        }
        if(less == -1 || more == end){
            return findNext(nums , begin , end-1);
        }
        return false;
    }
    public ArrayList<Integer> backOrder(TreeNode root , ArrayList<Integer> list){
        if(root == null){return list;}
        if(root.left  != null ){list = backOrder(root.left  , list);}
//        else{list.add("#");}
        if(root.right != null ){list = backOrder(root.right , list);}
//        else{list.add("#");}
        list.add(root.value);
        return list;
    }
}
public class No45 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
//        TreeNode n6 = new TreeNode(7);

        root.left = n1; root.right = n3;
//        n1.left = n6;
        n1.left = n2;
        n3.left = n4; n3.right = n5;

        ArrayList<Integer> list = new ArrayList<Integer>();
        Solution45 solution = new Solution45();
        System.out.println(solution.backOrder(root , list));
    }
}
