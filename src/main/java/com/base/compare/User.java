package com.base.compare;


/**
 * @author tiandongbo
 * @date 2020/5/24 17:57
 */


public class User implements Comparable<User> {

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //第一种方式
    @Override
    public int compareTo(User o) {
        // 首先根据年龄排序
        int sort = this.getAge() - o.getAge();
        return sort;
    }

    //第二种方式 函数是接口
    public int compare(User u1, User u2) {
        int diff = u1.getAge() - u2.getAge();
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
}
