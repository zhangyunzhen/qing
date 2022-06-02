package com.zyz.algorithm.collection.stack;

/**
 * 自己实现stack
 * <p>
 *      重要变量：
 *          object[] items; //元素
 *          int pos;      //栈顶指针
 *          int capacity;    //容量
 * <p>
 *      主要方法：
 *          boolean push(E val); //入栈
 *          E pop();      //出栈
 *          int size();   //容量
 *
 * @author yunzhen.zhang
 * @date 2021/10/26
 */
public class MyArrayStack<E> {

    private Object[] items;

    private int pos;

    private int capacity;


    public MyArrayStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("容量不合法");
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public boolean push(E val) {

        //判断容量是否满了
        if (pos == capacity) return false;

        items[pos] = val;
        pos++;
        return true;
    }


    public E pop() {
        //判断栈是否空的
        if (--pos == -1) return null;
        return (E) items[pos];
    }

    public static void main(String[] args) {
        MyArrayStack<String> stack = new MyArrayStack<>(5);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("d");
        stack.push("e");
        stack.push("f");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
