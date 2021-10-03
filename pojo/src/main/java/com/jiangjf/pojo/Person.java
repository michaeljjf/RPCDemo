package com.jiangjf.pojo;

import java.io.Serializable;

/**
 * @author jiangjf
 * @date 2021/10/3
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 8902198745769557470L;

    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
