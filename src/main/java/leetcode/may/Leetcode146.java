package leetcode.may;

import java.util.*;

/**
 * 设计lru缓存框架
 *
 * @Version : 1.0
 * @Creation : 2022/5/7 上午11:54
 * @Author : ksice_xt
 */
public class Leetcode146 {

    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "e");
        //new add
        map.get("1");
        map.get("2");
        for (Iterator<String> iterator = map.values().iterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.print(name);
        }
    }

    /**
     * 继承map实现lru淘汰算法
     */
//    class LRUCache extends LinkedHashMap<Integer, Integer> {
//
//        private int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity, 0.75F, true);
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            return super.getOrDefault(key, -1);
//        }
//
//        public void put(int key, int value) {
//            super.put(key, value);
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//            return size() > capacity;
//        }
//    }

    /**
     * 双向链表加hashmap实现lru，map无序查询o(1)，链表有序，可以知道哪个key最老,然后找到key进行移除
     */
    class LRUCache {

        /**
         * 自定义双向链表
         */
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();

        private int size;

        //容量大小
        private int capacity;

        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            //如果存在要移到头部,因为使用之后要挪到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {

            DLinkedNode node = cache.get(key);

            if (node == null) {
                //如果key不存在则创建一个新节点
                DLinkedNode newNode = new DLinkedNode(key, value);

                cache.put(key, newNode);

                addToHead(newNode);

                ++size;

                //如果目前值大于容量大小
                if (size > capacity) {

                    //将链表的节点删除，然后拿到节点的值
                    DLinkedNode node1 = removeTail();

                    cache.remove(node1.key);

                    //移除节点减小size大小
                    --size;
                }
            } else {
                node.value = value;
                cache.put(key, node);
                moveToHead(node);
            }
        }

        /**
         * 添加一个节点到头部，就是将上游换成头部，
         * 下游换成head下游，然后head的上下游也要改变指向
         *
         * @param node
         */
        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(DLinkedNode node) {
            //移除当前节点，就是将当前节点的上个节点的下游指向当前节点的下游
            node.prev.next = node.next;

            //移除当前节点，就是将当前节点下个节点的上游指向当前节点的上游
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            //先将当前节点移除掉
            removeNode(node);

            //然后将节点添加到head
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            //移除最久未使用的节点
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }


    }
}

