package swordfingeroffer;

import java.util.HashMap;

/**
 * 复杂链表的复制
 *
 * @Version : 1.0
 * @Creation : 2022/3/31 下午1:33
 * @Author : ksice_xt
 */
public class Offer35 {

    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;

        //通过第一次循环得到老的链表里面所有节点的next的关系
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;

        //二次循环拼接节点关系
        while (cur != null) {
            //第一次是新节点的head的
            Node node = map.get(cur);

            //设置新的节点的next和radom，为什么不直接一个循环一个一层一层的赋值呢，
            //因为radom可能指向还未创建的节点，所有要先将所有节点都给创建好在进行拼接
            node.next = map.get(cur.next);

            node.random = map.get(cur.random);

            cur = cur.next;
        }

        Node node = map.get(head);

        return node;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
