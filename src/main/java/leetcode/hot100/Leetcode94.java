package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/6/16 下午5:20
 * @Author : ksice_xt
 */
public class Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        zxbl(list, root);
        return list;
    }

    public void zxbl(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        //中序遍历，先左根右
        zxbl(list, root.left);
        list.add(root.val);
        zxbl(list, root.right);
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
