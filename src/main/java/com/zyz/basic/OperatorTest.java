package com.zyz.basic;

import org.junit.Test;

/**
 * @Author: YunzhenZhang
 * @Description: 运算符测试
 * <<      左移运算符
 * << num   向左移num，在原有数据的基础上乘2的num次方
 * >>      带符号右移运算符
 * >> num   带符号右移num位，在原有数据基础上除2的num，取整
 * >>>     无符号右移（右移之后符号为也参与运算）
 * >>> num 无符号的右移num位，在原有数据基础上除2的num，取整
 * <p>
 * <p>
 * ^  位异运算符
 * a ^ b 将两个数字转化为二进制数字，然后按高位到低位着个比较，相同为0，异同为1，最后将比较结果转化为十进制
 * @Date: Created in 12:14 2019/1/13
 */
public class OperatorTest {

    @Test
    public void test() {
        int a = -39;
        System.out.println(a << 2);
        System.out.println(a >> 3);
        System.out.println(a >>> 16);
    }

    @Test
    public void test1() {
        Integer a = 11;
        Integer b = 1;
        System.out.println(a ^ b);
        a = -129;
        b = -129;
        System.out.println(a ^ b);
        // integer类型-128~127的数字才能使用==的方式比较数字
        System.out.println(a==b);

    }


    @Test
    public void test2(){
/*        User user = new Father();
        System.out.println(user instanceof User);
        System.out.println(user instanceof Mother);
        System.out.println(user.getClass().getSimpleName());*/

        System.out.println(A.OperatorTest == A.OperatorTest);

    }

}
