package leetcode.july;

/**
 * @author ksice
 * @since 2022-07-21 下午3:54
 */
public class Leetcode814 {

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

    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {

            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left != null || root.right != null) {
            //因为还未到叶子结点
            return root;
        }

        //到叶子结点才判断
        return root.val == 0 ? null : root;

    }
}
