package leetcode.july;

/**
 * @Version : 1.0
 * @Creation : 2022/7/13 下午3:35
 * @Author : ksice_xt
 */
public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = invertTree(root.left);
        TreeNode treeNode1 = invertTree(root.right);
        root.right = treeNode;
        root.left = treeNode1;
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
