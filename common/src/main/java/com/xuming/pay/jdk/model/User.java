package com.xuming.pay.jdk.model;

import lombok.Data;

/**
 * 用户
 *
 * @author xuming.chen
 * @create 2021/8/25 10:52 下午
 **/
@Data
public class User {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;
}
