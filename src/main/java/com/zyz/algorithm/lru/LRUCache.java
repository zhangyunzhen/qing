package com.zyz.algorithm.lru;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * LRU最近最少使用缓存(链表+hashMap方式)
 *
 *      重要变量：
 *          HashMap<K,Node>  // 存储缓存元素
 *          Node head         //链表头部
 *          Node tail        //链表尾部
 *          int capacity        //容量
 *      方法：
 *          int size();     //长度
 *          V get()         //获取元素
 *              若元素存在，将get元素放到最前面
 *          void put(K,V)：  // 存储元素
 *              先去查找key是否存在，若存在，删除元素，并将元素移动链表头部
 *              若不存在，链表尾部插入，若size不够，删除链表尾部元素
 *          void remove(K key);
 *
 *      头插法（链表的第一个节点叫做头节点）
 *
 *
 * @author yunzhen.zhang
 * @date 2021/08/19
 */
public class LRUCache<K, V> {

    private Map<K, ListNode> map;

    private ListNode head;

    private ListNode tail;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        ListNode node = map.get(key);
        if (node == null) return null;

        // 链表中删除元素
        remove(node);
        // 移动到链表头部
        moveToHead(node);
        return (V) node.val;
    }

    public void put(K key, V value) {

        //先去查找key是否存在，若存在，删除元素，并将元素移动链表尾部
        if (map.get(key) != null) {
            get(key);
            // 重新设置值
            map.get(key).val = value;
        } else {
            // 若不存在，链表头部插入，若size不够，删除链表尾部元素
            ListNode listNode = new ListNode(key, value);
            map.put(key, listNode);
            moveToHead(listNode);
            if (map.size() > capacity) {
                // 删除尾部元素
                removeLast();
            }
        }
    }

    public V remove(K k) {
        ListNode node = map.remove(k);
        if (node == null) {
            return null;
        }
        remove(node);
        return (V) node.val;
    }


    public void remove(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    public void removeLast() {
        ListNode pre = tail.pre;
        remove(pre);
    }


    public void moveToHead(ListNode node) {
        ListNode next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    public void printAll() {
        ListNode cur = head.next;
        while (cur != null) {
            System.out.println(cur.key + ":" + cur.val);
            cur = cur.next;
        }
    }


    public class ListNode<K, V> {
        private K key;

        public V val;

        private ListNode pre;

        private ListNode next;

        public ListNode() {
        }

        public ListNode(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public ListNode(K key, V val, ListNode pre, ListNode next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.get("1");
        cache.put("4", "4");
        cache.printAll();

/*
        cache.put("4", "4");
        cache.remove("4");
        cache.put("5", "5");
        String s = cache.get("1");
        System.out.println(s);*/

    }
}
