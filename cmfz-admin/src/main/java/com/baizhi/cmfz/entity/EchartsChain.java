package com.baizhi.cmfz.entity;

/**
 * Created by Lee on 2018/7/9.
 */
public class EchartsChain {
    private String name;
    private String value;
    private String sex;

    public EchartsChain(String name, String value, String sex) {
        this.name = name;
        this.value = value;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "EchartsChain{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
