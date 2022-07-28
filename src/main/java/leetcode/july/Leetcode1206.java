package leetcode.july;

import java.util.Random;

/**
 * 跳表模拟
 * @author ksice
 * @since 2022-07-26 上午11:43
 */
public class Leetcode1206 {

    public static void main(String[] args) {
        Leetcode1206 skiplist = new Leetcode1206();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.search(0);   // 返回 false
        skiplist.add(4);
        skiplist.search(1);   // 返回 true
        skiplist.erase(0);    // 返回 false，0 不在跳表中
        skiplist.erase(1);    // 返回 true
        skiplist.search(1);
    }

    int level = 10;

    class Node {
        int val;
        Node[] ne = new Node[level];

        Node(int _val) {
            val = _val;
        }
    }

    Random random = new Random();
    Node he = new Node(-1);

    void find(int t, Node[] ns) {
        Node cur = he;

        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < t) {
                cur = cur.ne[i];
            }
            ns[i] = cur;
        }
    }

    public boolean search(int t) {
        Node[] ns = new Node[level];

        find(t, ns);
        Node node = ns[0].ne[0];
        return node != null && node.val == t;
    }

    public void add(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = new Node(t);


        for (int i = 0; i < level; i++) {
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if (random.nextInt(2) == 0) {
                break;
            }
        }
    }

    public boolean erase(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = ns[0].ne[0];

        if (node == null || node.val != t) {
            return false;
        }

        for (int i = 0; i < level && ns[i].ne[i] == node; i++) {
            ns[i].ne[i] = node.ne[i];
        }
        return true;
    }

}
