/*
 * 文件名：test.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2018年1月10日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz;

import com.alibaba.fastjson.JSON;
import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.LockSupport;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
/*        int a = 1;
        Integer b = new Integer(1);
        Integer c = new Integer(1);
        System.out.println("基本数据类型和包装类型比较："+(a==b));
        System.out.println("包装类和包装类==比较："+(b==c));
        System.out.println("包装类和包装类equal比较"+b.equals(c));
        System.out.println("基本数据类型和包装类比较："+(a==b.intValue()));*/

        String aaa = "aaa";
        String bbb = new String("aaa");
        String intern = bbb.intern();
        System.out.println(aaa == intern);
    }

    @Test
    public void switchTest1() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        list.add(1);
        list.add(null);
        System.out.println(list.toString());
    }

    @Test
    public void test3() {
        Random random = new Random();
        System.out.println(new Random().nextInt(10));
        System.out.println(new Random().nextInt(10));
        System.out.println(new Random().nextInt(10));
        System.out.println(new Random().nextInt(10));
    }

    @Test
    public void test4(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        treeSet.add(-1);
        treeSet.add(10);

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }


    /**
     * 使用switch，一定要在case加break，不然会顺序执行下面的代码。
     */
    @Test
    public void switchTest() {
        int a = 1;
        switch (a) {
            case 0:
                System.out.println("aaa");
                break;
            case 1:
                System.out.println("bbb");
                break;
            case 2:
                System.out.println("ccc");
                break;
        }
    }


    /**
     * 在精确计算中尽量不要使用float，double浮点类型会直接计算，会损失精度
     * 应该使用bigDecimal数据类型，精确度更高（如算价等）
     */
    @Test
    public void testBigDecimal() {
        System.out.println(1.01 + 2.02);
        double a = 0.1;
        System.out.println(a * 3);
        //bigdecimal也存在精度损失，但相比较float,double来说，精确度更高
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println(bigDecimal.multiply(BigDecimal.valueOf(3)).toString());
    }

    /**
     * 将方法参数定义为final类型，标识该参数内存地址不可变，但值可以变(指对象)
     * 常量的值在编译期间就已经确定了。
     */
    @Test
    public void testFinal() {
        Map<String, String> map = Maps.newHashMap();
        String aa = testFianl(map, "aa");
        System.out.println(map.get("aa"));
        System.out.println(aa);
    }

    public String testFianl(final Map<String, String> map, final String aa) {
        map.put("aa", "aaa");
        //aa = "bb";    编译会不通过
        return aa;
    }

    @Test
    public void aa(){
        List<String> list = new ArrayList<>();

        HashSet<Object> set = new HashSet<>();
    }

    @Test
    public void testRandom() {
        Random random = new Random(3);
        Random random1 = new Random(3);

        int i = 0;
        while (i < 10) {
            int n = random.nextInt(10);
            System.out.print(n);
            System.out.println(random1.nextInt(10));
            i++;
        }
    }

    @Test
    public void dataTest() throws ParseException {
        long time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("1970-01-01 08:00:00").getTime();
        System.out.println(time);
    }

    /**
     * 正则表达式匹配
     * .  匹配除换行符 (\n)之外的任意字符
     * [] 匹配一个字符列表
     * * 匹配零次或多次前面的字符
     * + 匹配一次或多次前面的字符
     */
    @Test
    public void testRegular() {
        String str = "asdasd123ASD";
        System.out.println(".匹配字符==" + str.replaceAll("a.d", "-"));
        System.out.println("[]匹配一个字符列表==" + str.replaceAll("[ad]", "-"));
        System.out.println("[]匹配一个字符列表(a到c)==" + str.replaceAll("[a-c]", "-"));
        System.out.println("[]匹配一个字符列表(除了a-c)==" + str.replaceAll("[^a-c]", "-"));


        //匹配3-7位 包含数字和大写字母的字符串
        String pattern = "^(?![0-9]+$)(?![A-Z]+$)[0-9A-Z]{3,7}$";
        //匹配13位纯数字
        String pattern1 = "^[0-9]{13}$";
        //匹配时间yyyy-mm-dd
        String pattern2 = "((((19|20)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((19|20)\\d{2})-(0?[469]|11)-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-(0?[1-9]|[12]\\d)))$";

        System.out.println(Pattern.matches(pattern2, "2010-11-11"));
    }


    @Test
    public void testRegula() {
        String str = "\"birthday\":100kS$xZ000,";
        System.out.println(".匹配字符==" + str.replaceAll("a.d", "-"));
        System.out.println("[]匹配一个字符列表==" + str.replaceAll("[ad]", "-"));
        System.out.println("[]匹配一个字符列表(a到c)==" + str.replaceAll("[a-c]", "-"));
        System.out.println("[]匹配一个字符列表(除了a-c)==" + str.replaceAll("[^a-c]", "-"));


        //匹配3-7位 包含数字和大写字母的字符串
        String pattern = "^(?![0-9]+$)(?![A-Z]+$)[0-9A-Z]{3,7}$";
        //匹配13位纯数字
        String pattern1 = "^[0-9]{13}$";
        //匹配时间yyyy-mm-dd
        String pattern2 = "((((19|20)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((19|20)\\d{2})-(0?[469]|11)-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-(0?[1-9]|[12]\\d)))$";

        System.out.println(Pattern.matches(pattern2, "2010-11-11"));
    }

    @Test
    public void test() {
  /*      System.out.println(CharMatcher.DIGIT.retainFrom("0S"));
        System.out.println(CharMatcher.DIGIT.retainFrom("S"));
        System.out.println(  CharMatcher.DIGIT.removeFrom("S"));*/

        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        List<String> list = strings.subList(0, 5);
    }


    @Test
    public void test999() {
        String pattern12 = "^[0-9]\\d*%基本保障额度$";
        boolean matches = Pattern.matches(pattern12, "100%基本保障额度");
        BigDecimal bigDecimal = new BigDecimal("100％基本保障额度".substring(0, "100％基本保障额度".length() - 7));
        BigDecimal divide = new BigDecimal("500000").multiply(bigDecimal).divide(new BigDecimal(100));
        System.out.println(matches);
        System.out.println(bigDecimal);
        System.out.println(divide);
    }

    @Test
    public void test9999() {
        String pattern12 = "该款产品被保人年龄应在%s岁至%s岁之间，以下被保人不满足:";
        String format1 = String.format(pattern12, Arrays.asList("a", "b"));
        System.out.println(format1);

    }

    @Test
    public void test1000() {
        String a = "对不起 被保人%s符合BMI投保范围";
        String s = String.format(a, "新");
        System.out.println(s);
    }

    @Test
    public void test10001() {
        BigDecimal bigDecimal = BigDecimal.valueOf(7156);
        BigDecimal multiply = bigDecimal.multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(2, 2), BigDecimal.ROUND_HALF_UP);
        System.out.println(BigDecimal.valueOf(2, 10).toString());
        System.out.println(multiply.toString());
    }

    @Test
    public void test111() {
        List<Integer> list = Arrays.asList(1, 5, 2, 7, 3);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void test222() {
        TreeMap<String, String> paramTreeMap = new TreeMap();
        paramTreeMap.put("uuid", "aaa");
        paramTreeMap.put("merchantId", "ccc");
        paramTreeMap.put("charset", "ddd");
        paramTreeMap.put("signType", "gggggg");
        paramTreeMap.put("timestamp", "lllla");
        paramTreeMap.put("version", "pppqwe");
        paramTreeMap.put("data", "asdasdd");
    }

    @Test
    public void testaaaa() {
        int maxSum = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println(maxSum + "=====" + minValue);
    }

    @Test
    public void test3333() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());

        System.out.println(cal.get(11));
    }


    @Test
    public void test444() throws InterruptedException {
        synchronized (this) {
            ThreadLocal<User> local1 = new ThreadLocal<>();
            ThreadLocal<User> local2 = new ThreadLocal<>();
            User user = new User();
            user.setName("张三");
            local1.set(user);
            local2.set(user);
            local1.get().setName("李四");
            Thread.sleep(1000L);
            System.out.println(JSON.toJSONString(local2.get()));
        }
    }

    @Test
    public void testz() {
        //System.out.println(4^2);
        System.out.println(1 << 1);

        int[] a = new int[10];
        Arrays.sort(a);
    }

    @Test
    public void testzzz() {
        int[][] a = new int[10][0];
        a[0][0] = 1;
        System.out.println(a[0].length);
    }

    @Test
    public void testQmonitor() {
      /*  ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(threadBean.getThreadCount());



        System.out.println(JSON.toJSONString(threadBean.getAllThreadIds()));
        System.out.println(JSON.toJSONString(threadBean.getThreadInfo(1)));
        System.out.println(JSON.toJSONString(threadBean.getThreadInfo(2)));
        System.out.println(JSON.toJSONString(threadBean.getThreadInfo(3)));
        System.out.println(JSON.toJSONString(threadBean.getThreadInfo(4)));
        System.out.println(JSON.toJSONString(threadBean.getThreadInfo(13)));*/
/*
        monitorRet.put("JVM_Thread_Count", (long)threadBean.getThreadCount());
        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        Iterator i$ = beans.iterator();

        String name;
        while(i$.hasNext()) {
            GarbageCollectorMXBean bean = (GarbageCollectorMXBean)i$.next();
            name = "JVM_" + bean.getName();*/


        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        Iterator i$ = beans.iterator();

        String name;
        while (i$.hasNext()) {
            GarbageCollectorMXBean bean = (GarbageCollectorMXBean) i$.next();
            System.out.println(bean.getName() + "===" + bean.getCollectionCount() + "=======" + bean.getCollectionTime());
        }
    }
}
