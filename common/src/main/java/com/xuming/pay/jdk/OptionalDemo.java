package com.xuming.pay.jdk;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.xuming.pay.jdk.model.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 对java.util.Optional的学习
 * A container object which may or may not contain a non-null value.
 * Optional是一个容器,正确使用它可以避免一些空指针异常
 *
 * @author xuming.chen
 * @create 2021/8/25 10:01 下午
 **/
public class OptionalDemo {
    public static void main(String[] args) {
//        of();
//        ofNullableAndOthers();
//        get();
//        getExtensionMethod1();
//        getExtensionMethod2();
//        upgradeMethod();

//        combineWithStreamApiMap();
//        combineWithStreamApiToMap();
//        combineWithStreamApiFilter();
        nullThenOrElseEmptyList();
    }

    /**
     * Returns an Optional with the specified present non-null value.
     * @throws NullPointerException if value is null
     *
     * 在value non-null的前提下,返回一个Optional;否则直接抛空指针异常
     */
    private static void of() {
        String s = null;
        Optional<String> optional = Optional.of(s);
    }

    /**
     * java.util.Optional#ofNullable(java.lang.Object)及其他相关方法学习
     * 包括isPresent()、get()方法等
     */
    private static void ofNullableAndOthers() {
        String s = null;
        Optional<String> optional = Optional.ofNullable(s);
        // Optional.empty
        System.out.println(optional);
        // Optional.empty
        System.out.println(optional.toString());
        System.out.println(optional.isPresent());
        // @throws NoSuchElementException if there is no value present
        System.out.println(optional.get());
    }

    private static void get() {
        String s = "hello world";
        Optional<String> optional = Optional.ofNullable(s);
        // Optional[hello world]
        System.out.println(optional);
        // Optional[hello world]
        System.out.println(optional.toString());
        // hello world
        System.out.println(optional.get());
    }

    /**
     * for循环中，若s为null，则optional.get()抛NoSuchElementException异常
     */
    private static void getExtensionMethod1() {
        Random random = new Random();
        String s;
        for (int i = 0; i < 5; i++) {
            s = random.nextBoolean() ? "hello world" : null;
            Optional<String> optional = Optional.ofNullable(s);
            System.out.println(String.format("s=[%s]， optionalValue=[%s]", s, optional.get()));
        }
    }

    /**
     * getExtensionMethod1()的改进版，通过isPresent()方法，避免抛异常
     */
    private static void getExtensionMethod2() {
        Random random = new Random();
        String s;
        for (int i = 0; i < 5; i++) {
            s = random.nextBoolean() ? "hello world" : null;
            Optional<String> optional = Optional.ofNullable(s);
            if (optional.isPresent()) {
                System.out.println(String.format("s=[%s], optionalValue=[%s]", s, optional.get()));
            } else {
                System.out.println(String.format("s=[%s], 不调用optional.get()方法，否则报错", s));
            }

        }
    }

    /**
     * 某种意义上，是getExtensionMethod2()的进一步升级
     * Optional.ofNullable(T value).orElse(T other)，返回值是T
     * T是具体的value类型，不是Optional类
     */
    private static void upgradeMethod() {
        Random random = new Random();
        String s;
        for (int i = 0; i < 5; i++) {
            s = random.nextBoolean() ? "hello world" : null;
            String str = Optional.ofNullable(s).orElse("default str");
            System.out.println(String.format("s=[%s], str=[%s]", s, str));
        }
    }

    /**
     * 组合Stream Api的map()使用
     */
    private static void combineWithStreamApiMap() {
        List<User> userList = createUserList();
        List<Integer> idList = Optional.ofNullable(userList).orElse(new ArrayList<>())
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());
        System.out.println(idList);
    }

    /**
     * 组合Stream Api的toMap()使用
     */
    private static void combineWithStreamApiToMap() {
        List<User> userList = createUserList();
        Map<Integer, User> map = Optional.ofNullable(userList).orElse(new ArrayList<>())
                .stream()
                // Function.identity() : Returns a function that always returns its input argument.
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(JSON.toJSONString(map));
    }

    /**
     * 组合Stream Api的filter()使用
     */
    private static void combineWithStreamApiFilter() {
        List<User> userList = createUserList();
        // 过滤得到年龄大于30的用户列表
        List<User> ageGt30UserList = Optional.ofNullable(userList).orElse(new ArrayList<>())
                .stream()
                .filter(user -> user.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(ageGt30UserList));
    }

    /**
     * Optional.ofNullable(T value) => 当value为null时取orElse的值
     */
    private static void nullThenOrElseEmptyList() {
        List<User> userList = null;
        // 由于userList为null,这一行的取值实际是new ArrayList<>()即一个空列表
        List<User> users = Optional.ofNullable(userList).orElse(new ArrayList<>());
        System.out.println(users);

        List<String> userNameList = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(userNameList);
    }

    /**
     * 创建用户列表
     *
     * @return
     */
    private static List<User> createUserList() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Yao");
        user1.setAge(26);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Yi");
        user2.setAge(24);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Wang");
        user3.setAge(35);

        return Lists.newArrayList(user1, user2, user3);
    }



}
