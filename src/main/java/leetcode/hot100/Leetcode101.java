package leetcode.hot100;

/**
 * @Version : 1.0
 * @Creation : 2022/6/20 上午10:20
 * @Author : ksice_xt
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {

        return check(root, root);
    }

    boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        //如果值相等就拿一棵树的左节点（右节点）和另外一棵树的右节点（左节点）相比，
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);

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
