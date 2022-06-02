package com.zyz.pattern;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 16:13 2019/1/9
 */
public class PatternTest {

    //匹配正整数
    private String pattern1 = "^[1-9]\\d*$";

    private String pattern2 = "^[1-9]\\d*-[1-9]\\d*$";
    private String pattern3 = "";
    private String pattern4 = "";
    private String pattern5 = "";

    private String pattern12 = "^基本保额\\*[1-9]\\d*%/[1-9]\\d*%/[1-9]\\d*%$";

    private String pattern13 = "^基本保额\\*[0-9]\\d*%/[1-9]\\d*%/[1-9]\\d*%$";

    private String pattern14 = "^基本保额：[1-9]\\d*-[1-9]\\d*万$";

    @Test
    public void test() {
        Pattern compile = Pattern.compile(pattern14);
        Matcher matcher = compile.matcher("基本保额：10-50万");
        boolean b = matcher.matches();
        System.out.println(b);
    }

    @Test
    public void test2() {
        String substring = "asdqwe".substring(0, 5);
        System.out.println(substring);
    }

}
