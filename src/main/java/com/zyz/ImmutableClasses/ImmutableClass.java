package com.zyz.ImmutableClasses;

import com.alibaba.fastjson.JSON;
import com.zyz.User;

/**
 * @Author: YunzhenZhang
 * @Description: 不可变类
 *      描述：
 *          类的实例被创建后不可被修改（成员变量）。线程安全。如String.
 *      需满足条件:
 *          1.类需要是常量类，不可被继承。 这样就不会被子类修改其成员变量。
 *          2.类的成员变量需要定义为final.    (对于基础类型和String来说，定义为final的变量值不可被修改。  对于其他对象实例变量来说，定义为final意味着对该实例的引用不可以改变，但可以改变实例内容)
 *          3.通过构造器初始化所有成员，进行深拷贝(deep copy)     （防止外部代码通过其他对该成员变量的引用修改该实例）
 *          4.成员变量不提供setter方法
 * @Date: Created in 10:03 2018/9/21
 */
public final class ImmutableClass {

    private final User user;

    public ImmutableClass(User user) {
        this.user= user.clone();
    }


    public User getUser() {
        return user;
    }


    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("a");
        ImmutableClass immutableClass = new ImmutableClass(user);
        user.setName("bb");
        //对不可变类成员变量赋值之后
        System.out.println(JSON.toJSONString(immutableClass.getUser()));
    }
}
