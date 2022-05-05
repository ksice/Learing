package leetcode.may;

/**
 * 二叉树的深度
 *
 * @Version : 1.0
 * @Creation : 2022/5/5 下午8:54
 * @Author : ksice_xt
 */
public class Swordfingeroffer55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
