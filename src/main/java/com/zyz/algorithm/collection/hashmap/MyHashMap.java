package com.zyz.algorithm.collection.hashmap;


/**
 * 散列表
 *        变量：
 *              Node<K,V>[] table;      // 散列表
 *              int size;               // 当前长度
 *              int capacity;           // 容量
 *        方法：
 *             V put(K key,V val);
 *             V get(K key);
 *             V remove(K key);
 *
 *        内部方法
 *            int hash(K key);          //散列函数
 *
 *
 * @author yunzhen.zhang
 * @date 2021/10/25
 */
public class MyHashMap<K, V> implements MyMap<K, V> {


    private Node<K, V>[] table;

    private int size;

    private int capcity;

    public MyHashMap(int capcity) {
        this.capcity = capcity;
        table = new Node[capcity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V put(K key, V val) {
        // 1.通过散列函数，找到槽位
        int slot = hash(key);

        if (table[slot] == null) {
            table[slot] = new Node<>(key, val, null);
            size++;

            // 可以扩容
            return val;
        }

        Node<K, V> node = table[slot];
        while (node != null) {
            if (node.key.equals(key)) {
                // key值相同，新值覆盖就值
                node.value = val;
                return val;
            }
            node = node.next;
        }

        if (node == null) {
            Node<K, V> kvNode = table[slot];
            table[slot] = new Node<>(key, val, kvNode);
            size++;
        }
        return val;
    }

    @Override
    public V get(K key) {
        int slot = hash(key);
        Node<K, V> node = table[slot];
        if (node == null) return null;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int slot = hash(key);
        Node<K, V> node = table[slot];
        if (node == null) return null;

        Node<K, V> pre = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (pre == null) {
                    table[slot] = node.next;
                } else {
                    pre.next = node.next;
                }
                size--;
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 散列函数
     * @param key
     * @return
     */
    public int hash(K key) {
        return hashKey(key) % table.length;
    }


    public int hashKey(Object key) {
        return key.hashCode();
    }


    static class Node<K, V> implements MyMap.Entry<K, V> {

        private K key;

        private V value;

        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>(10);
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        map.remove("b");
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));

    }
}
