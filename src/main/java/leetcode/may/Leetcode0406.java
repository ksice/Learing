package leetcode.may;

/**
 * 后继者
 *
 * @Version : 1.0
 * @Creation : 2022/5/16 上午11:07
 * @Author : ksice_xt
 */
public class Leetcode0406 {

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            if (root == null) {
                return null;
            }

            //bst 右节点大于根节点
            if (root.val <= p.val) {
                return inorderSuccessor(root.right, p);
            }
            TreeNode treeNode = inorderSuccessor(root.left, p);

            //treenode为null说明root就是下面节点
            return treeNode == null ? root : treeNode;
        }
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
