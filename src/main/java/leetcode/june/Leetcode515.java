package leetcode.june;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 * @Version : 1.0
 * @Creation : 2022/6/24 上午10:18
 * @Author : ksice_xt
 */
public class Leetcode515 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int max = Integer.MIN_VALUE;

            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                max = Math.max(poll.val, max);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

            list.add(max);
        }

        return list;
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
