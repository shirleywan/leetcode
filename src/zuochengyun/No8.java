package zuochengyun;

import java.util.*;
import zuochengyun.util.TreeNode;
/**
 * 构造数组的MaxTree
 *
 */
class Solution8{
    int length;
    TreeNode[] nodellist = new TreeNode[length];
    TreeNode[] Father = new TreeNode[2 * length];
    public void setLength(int[] nums){
        this.length = nums.length;
    }
    public TreeNode maxTree(int[] nums){
        if(nums.length ==0){return null;}
        int max = nums[0];
        int i = 0;
        for ( i = 0 ; i< nums.length ; i++){
            nodellist[i] = new TreeNode(nums[i]);
        }
        for ( i = 0 ; i< nums.length ; i++){
            if(nums[i] > max){ max = nums[i] ;}
        }
        TreeNode root = new TreeNode(max);
        for( i =0 ;i< nums.length ;i++){
            generate(nums , i);
        }
        for (TreeNode node : Father){
            System.out.println(node.value);
        }
        return root;
    }
    public void generate(int[] nums , int n){
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        TreeNode father = null;

        Stack<Integer> stack = new Stack<Integer>();
        for(int j = 0 ; j<n ; j++){
            if(nums[j]> nums[n]){stack.push(j);}
        }
        if(!stack.isEmpty()){left = stack.pop();}
        else{
            Father[n * 2] = null;
        }
        for(int j = nums.length-1 ; j>n ; j--){
            if(nums[j]> nums[n]){stack.push(j);}
        }
        if(!stack.isEmpty()){right = stack.pop();}
        else{
            Father[n * 2 + 1] = null;
        }
        if(left < right){
            Father[n*2]  = nodellist[left];
            Father[n*2+1] = null;
        }
        else {
            if(left > right) {
                Father[n * 2] = null;
                Father[n * 2 + 1] = nodellist[left];
            }
        }
    }
}
public class No8 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2} ;
        Solution8 solution = new Solution8();
        solution.setLength(nums);
        System.out.println(solution.maxTree(nums));
    }
}
