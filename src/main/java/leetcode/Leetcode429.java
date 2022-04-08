package leetcode;

import java.util.*;

/**
 * N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * @Version : 1.0
 * @Creation : 2022/4/8 上午9:48
 * @Author : ksice_xt
 */
public class Leetcode429 {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> lists = new ArrayList<>();

        //因为要从左到右一层一层遍历所有就是先进先出采用队列.queue是单向队列 fifo先进先出， deque双向队列
        Queue<Node> nodes = new ArrayDeque<>();

        if (root != null) {
            nodes.offer(root);
        }

        //为了判断是否还存在下层
        while (nodes.size() > 0) {

            //当前层次的节点数
            int size = nodes.size();

            List<Integer> list = new ArrayList<>();

            //将当前层次的节点的子类放到下次循环
            while (size-- > 0) {
                //将当前节点值取出，存入集合
                Node poll = nodes.poll();

                List<Node> children = poll.children;

                //获取当前节点的子类值，供下次循环使用
                for (Node node : children) {
                    nodes.offer(node);
                }

                list.add(poll.val);
            }
            lists.add(list);
        }

        return lists;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
