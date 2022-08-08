package leetcode.aug;

/**
 * add one row to tree
 *
 * @author ksice
 * @since 2022-08-05 下午4:10
 */
public class Leetcode623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        dfs(root, depth, 1, val);
        return root;
    }

    void dfs(TreeNode root, int depth, int index, int val) {

        if (depth == index + 1) {
            TreeNode left = new TreeNode(val);
            left.left = root.left;
            TreeNode right = new TreeNode(val);

            right.right = root.right;
            root.left = left;
            root.right = right;
            return;
        }

        if (root == null) {
            return;
        }

        index++;

        dfs(root.left, depth, index, val);
        dfs(root.right, depth, index, val);
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
