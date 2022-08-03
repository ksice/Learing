package leetcode.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksice
 * @since 2022-08-03 上午11:31
 */
public class Leetcode114 {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        fronted(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left=null;
            pre.right=cur;
        }

    }

    public void fronted(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        fronted(root.left,list);
        fronted(root.right,list);
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
