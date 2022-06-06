package leetcode.june;

/**
 * @Version : 1.0
 * @Creation : 2022/6/2 上午11:14
 * @Author : ksice_xt
 */

public class Leetcode450 {

    /**
     * 根据二叉搜索树的性质
     * <p>
     * 如果目标节点大于当前节点值，则去右子树中删除；
     * 如果目标节点小于当前节点值，则去左子树中删除；
     * 如果目标节点就是当前节点，分为以下三种情况：
     * 其无左子：其右子顶替其位置，删除了该节点；
     * 其无右子：其左子顶替其位置，删除了该节点；
     * 其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，然后右子树顶替其位置，由此删除了该节点。
     * <p>
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val == key) {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }

            TreeNode right = root.right;

            while (right.left != null) {
                right = right.left;
            }

            right.left = root.left;

            return root.right;

        } else if (val < key) {
            //小于key就去右节点删除
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
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
