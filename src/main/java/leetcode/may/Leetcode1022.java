package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/30 上午9:41
 * @Author : ksice_xt
 */
public class Leetcode1022 {

    public int sumRootToLeaf(TreeNode root) {

        return  dfs(root,0);
    }

    public int dfs(TreeNode root, int pre) {
        int ans = 0, ncur = (pre << 1) + root.val;
        if (root.left != null) {
            ans += dfs(root.left, ncur);
        }
        if (root.right != null) {
            ans += dfs(root.right, ncur);
        }
        return root.left == null && root.right == null ? ncur : ans;
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
