package leetcode.hot100;

/**
 * @Version : 1.0
 * @Creation : 2022/6/20 上午11:03
 * @Author : ksice_xt
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            int i = maxDepth(root.left);
//            int j = maxDepth(root.right);
//            return Math.max(i, j) + 1;
//        }
        int i = check(root, 0);
        int j = check(root, 0);
        System.out.println(i + "" + j);
        return Math.max(i, j);

    }

    int check(TreeNode root, int i) {
        if (root == null) {
            return 1;
        }
        return check(root.left, i) + 1;
    }


    int check1(TreeNode root, int j) {
        if (root == null) {
            return 1;
        }
      return   check1(root.right, j)+1;
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
