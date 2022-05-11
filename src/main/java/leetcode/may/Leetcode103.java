package leetcode.may;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @Version : 1.0
 * @Creation : 2022/5/11 下午5:36
 * @Author : ksice_xt
 */
public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        //用来判断是奇数还是偶数
        boolean isOrder = true;

        while (!queue.isEmpty()) {

            //双向队列，用来判断从尾部插入还是从头插入
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (isOrder) {
                    deque.addLast(poll.val);
                } else {
                    deque.addFirst(poll.val);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            lists.add(new LinkedList<>(deque));
            isOrder = !isOrder;
        }
        return lists;
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
