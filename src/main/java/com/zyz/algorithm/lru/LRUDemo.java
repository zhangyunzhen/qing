package com.zyz.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Description
 *
 *      HashMap<Key,Node> elements; //存储元素
 *      Node head;     //头节点
 *      Node tail;      //链表节点
 *      int capacity;
 *
 *
 *      V get(Key k); // 如果节点存在，移动到链表头部
 *      void put(V val);  // 1.先get()节点. 2. 如果元素不存在，插入链表头部 3. 如果数量超过容量大小，删除尾部节点
 *      int size()
 *
 * @author yunzhen.zhang
 * @date 2021/11/24
 */
public class LRUDemo<K, V> {


    HashMap<K, Node> elements; //存储元素
    Node head;     //头节点
    Node tail;      //链表节点
    int capacity;

    public LRUDemo(int capacity){
        this.capacity = capacity;
        elements = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K k) {

        Node node = elements.get(k);
        if(node==null) return null;

        remove(node);
        addHead(node);
        return (V) node.val;
    }

    void put(K key,V val){
        if(elements.get(key) != null){
            get(key);
            return;
        }

        Node node = new Node<K,V>(key,val,null,null);
        addHead(node);
    }

    int size(){
        return elements.size();
    }


    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addHead(Node node){
       Node next = head.next;
       head.next = node;
       node.prev = head;
       node.next = next;
       next.prev = node;
    }

    public class Node<K,V> {

        private V val;

        private K key;

        private Node prev;

        private Node next;

        public Node(){

        }

        public  Node(K key,V val,Node prev,Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }

}
