package com.zyz.algorithm.collection.stack;


/**
 * 链式栈
 * <p>
 *      重要变量：
 *          Node pop;   //栈顶
 *          int size;
 *
 *      重要方法：
 *          push(E val); //入栈
 *          E pop();  //出栈
 *          int size(); //栈中元素
 * @author yunzhen.zhang
 * @date 2021/10/26
 */
public class MyLinkedStack<E> {

    private Node pop;   //栈顶

    private int currentLength;

    public MyLinkedStack() {
    }

    // 入栈
    public boolean push(E val) {
        if(val == null) return false;

        if (pop == null) {
            pop = new Node<>(val, null);
        } else {
            Node node = new Node(val, pop);
            pop = node;
        }
        currentLength++;
        return true;
    }


    //出栈
    public E pop() {
        if (pop == null) return null;

        Node tmp = this.pop;
        this.pop = this.pop.next;
        currentLength--;
        return (E) tmp.val;
    }

    //栈中元素
    public int size() {
        return currentLength;
    }


    public class Node<E> {

        private E val;

        private Node next;

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        MyLinkedStack<String> stack = new MyLinkedStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
