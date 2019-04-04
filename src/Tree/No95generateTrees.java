package Tree;
import java.util.*;

import sun.reflect.generics.tree.Tree;
import utils.*;

/**
 * 95. Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * Example:
 *      Input: 3
 *      Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 *      The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
class SolutionOld95 {
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return null;
        List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
        for(int i = 1 ; i <= n ; i++){
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(new TreeNode(i));
            result.add(list);
        }
        return null;
    }
    public List<TreeNode> generateSubTree(int min , int max){
        if(max - min ==0) return null;
        List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
        for(int i = min ; i <= max ; i++){
            List<TreeNode> list = new ArrayList<TreeNode>();

            list.add(new TreeNode(i));

        }

        return null;
    }
}
class Solution95{
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees II.
     * Memory Usage: 38.8 MB, less than 57.32% of Java online submissions for Unique Binary Search Trees II.
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        return recursiveBuild(memo, 1, n + 1, n + 1);
    }

    public List<TreeNode> recursiveBuild(Map<Integer, List<TreeNode>> memo, int j, int k, int limit) {
        int index = j * limit + k;
        if (memo.containsKey(index)) return memo.get(index);
        List<TreeNode> result = new ArrayList<>();
        for (int i = j; i < k; i++) {
            List<TreeNode> leftNodes = recursiveBuild(memo, j, i, limit);
            List<TreeNode> rightNodes = recursiveBuild(memo, i + 1, k, limit);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        if (result.size() == 0) {
            result.add(null);
        }
        memo.put(index, result);
        return result;
    }
}
public class No95generateTrees {
    public static void main(String[] args){
        int n = 3;
        System.out.println(new Solution95().generateTrees(n));
    }
}
