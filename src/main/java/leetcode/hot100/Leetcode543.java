package leetcode.hot100;

/**
 * 二叉树的直径
 *
 * @Version : 1.0
 * @Creation : 2022/6/22 下午3:01
 * @Author : ksice_xt
 */
public class Leetcode543 {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return ans;

    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, right + left + 1);
        return Math.max(right, left) + 1;
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
