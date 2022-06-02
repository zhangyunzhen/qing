package com.zyz.algorithm.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2020/12/21
 */
public class javaStackTest {


    /**
     * java Stack类
     * 特性：线程安全的
     * 操作：入栈：push; 返回栈顶元素:peek; 出栈：pop；
     */
    @Test
    public void testStack1() {
        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     * <p>
     * 两个数组，一个代表压栈，一个代表出栈，判断数组元素是否正确？
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }
}
