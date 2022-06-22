package leetcode.hot100;

/**
 * 查找二叉树的最左节点
 * @Version : 1.0
 * @Creation : 2022/6/22 下午12:06
 * @Author : ksice_xt
 */
public class Leetcode513 {

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

    int max = 0, ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode root, int deepth) {

        if (root == null) {
            return;
        }

        if (deepth > max) {
            max = deepth;
            ans = root.val;
        }

        //先找左节点这样同级别的右节点就没法干扰了
        dfs(root.left,deepth+1);
        dfs(root.right,deepth+1);


    }

}
