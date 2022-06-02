package com.zyz.algorithm.character;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 大小写转换
 *      10080 转换： 一万零八十元
 *
 * 思路：
 *      1.校验字符串是否是数字
 *          检验是否是空，是否为0
 *          校验是否是数字
 *      2.做数字和单位的映射
 *      3.拆分字符串,分成整数和小数部分
 *      4.转换整数
 *          0的处理
 *              0在个位，万位，亿位，则转换单位
 *              0后面一位是数字，则转换零
 *          直接转换
 *      5.转换小数部分
 *
 *
 * 需要注意的地方：
 *    字符转数字的地方：
 *      Integer.valueOf(c - '0');
 *    注意遍历数字过程中获取单位时的下标：
 *      num.length()-i-1;
 *    注意字符串分割
 *
 *
 * @author yunzhen.zhang
 * @date 2021/10/20
 */
public class AmountUpper {


    /**
     * 大写数字
     */
    String[] upper = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "扒", "玖"};

    /**
     * 单位
     */
    String[] unit = {"元", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};


    String[] decimalUnit = {"角", "分", "厘"};


    Pattern compile = Pattern.compile("[0-9]+\\.?[0-9]*");

    /**
     * @param amount
     * @return
     */
    public String amountUpper(String amount) {

        StringBuilder res = new StringBuilder();

        // 校验是不是数字
        if ("0".equals(amount)) {
            return "零元";
        }
        Matcher matcher = compile.matcher(amount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("不是数字");
        }


        String integer;
        String decimals = null;

        // 取整数和小数部分
        int index = amount.indexOf(".");
        if (index == -1) {
            integer = amount;
        } else {
            integer = amount.substring(0, index);
            decimals = amount.substring(index + 1);
        }


        // 整数转换
        String integerStr = integerConvert(integer);
        // 小数转换
        String decimalStr = decimalConvert(decimals);

        return integerStr + decimalStr;
    }


    /**
     * 整数转换
     * @param amount
     * @return
     */
    public String integerConvert(String amount) {

        //一个个遍历
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < amount.length(); i++) {
            char c = amount.charAt(i);
            // 单位的下标
            int unitIndex = amount.length() - i - 1;
            // 数字的下标
            int numIndex = Integer.valueOf(c - '0');

            //零的处理
            if (numIndex == 0) {
                // 判断是不是元，万，亿位
                if (unitIndex == 0 || unitIndex == 4 || unitIndex == 8) {
                    buffer.append(unit[unitIndex]);
                }
                // 判断后面一位是不是0
                if ((i != amount.length() - 1) && Integer.valueOf(amount.charAt(i + 1) - '0') != 0) {
                    buffer.append(upper[0]);
                }
            } else {
                //获取数字
                String number = upper[numIndex];
                //获取单位（注意这块儿的下标取值）
                String unit = this.unit[unitIndex];
                buffer.append(number);
                buffer.append(unit);
            }
        }

        return buffer.toString();
    }

    /**
     * 小数转换
     * @param decimal
     * @return
     */
    public String decimalConvert(String decimal) {

        if (decimal == null) {
            return "";
        }

        StringBuffer buffer = new StringBuffer();

        String str = decimal.substring(0, 3);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer integerIndex = Integer.valueOf(c - '0');
            //获取数字
            String number = upper[integerIndex];

            //获取单位（注意这块儿的下标取值）
            String unit = this.decimalUnit[i];
            buffer.append(number);
            buffer.append(unit);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        AmountUpper demo = new AmountUpper();
        // String s = demo.amountUpper(200001234);
        String decimalConvert = demo.amountUpper("123123.123");
        System.out.println(decimalConvert);
    }

}
