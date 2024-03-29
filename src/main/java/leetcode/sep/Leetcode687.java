package leetcode.sep;

/**
 * dfs
 * @author ksice
 * @since 2022-09-05 下午5:27
 */
public class Leetcode687 {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;

    }


    int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int left1 = 0;
        int right1 = 0;


        if (root.left != null && root.val == root.left.val) {
            left1 = left + 1;
        }

        if (root.right != null && root.val == root.right.val) {
            right1 = right + 1;
        }

        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
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
