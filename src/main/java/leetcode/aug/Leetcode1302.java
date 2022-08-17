package leetcode.aug;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ksice
 * @since 2022-08-17 下午4:21
 */
public class Leetcode1302 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(0);
        deque.add(1);
        deque.add(2);

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pop());

    }
    public int deepestLeavesSum(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();

        int ans = 0;

        while (!deque.isEmpty()) {

            int size = deque.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode treeNode = deque.pollLast();
                sum += treeNode.val;

                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }

            }
            ans = sum;
        }

        return ans;
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
