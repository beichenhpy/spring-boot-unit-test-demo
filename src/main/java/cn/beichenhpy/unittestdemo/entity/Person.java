package cn.beichenhpy.unittestdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author beichenhpy
 * @version 1.0
 * @description TODO
 * @since 2021/2/3 9:55
 */
@Data
public class Person implements Serializable {
    private String name;
    private Integer age;
}
