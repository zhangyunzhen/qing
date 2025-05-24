package com.zyz.algorithm.character;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2022/05/08
 */
public class StringDemo {

    /**
     *  两个大数相加
     *      101+201
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {

        if (num1 == null || "".equals(num1)) return num2;

        if (num2 == null || "".equals(num2)) return num1;

        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }


}
