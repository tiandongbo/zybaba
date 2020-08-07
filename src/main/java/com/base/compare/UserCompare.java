package com.base.compare;

import org.junit.Test;

import java.util.*;

/**
 * @author tiandongbo
 * @date 2020/5/24 18:08
 */
public class UserCompare {
    @Test
    public void testCase01() {

        //List 对对象比较并排序
        List<User> list = new ArrayList<User>();
        list.add(new User("张三", 5));
        list.add(new User("李四", 30));
        list.add(new User("王五", 19));
        list.add(new User("陈十七", 17));
        Collections.sort(list);
        System.out.println(list.toString());
        list.add(new User("田东波", 12));
        //Collections.sort(list,   User::compareTo );
        Collections.sort(list,(a,b)->a.getAge()-b.getAge());
        System.out.println(list.toString());

        User[]  users= {new User("张三", 5),new User("李四", 30),new User("王五", 19) };

        Arrays.stream(users).sorted((a,b)->a.getAge()-b.getAge()).forEach(e->
                         System.out.println(e.getAge()));


        Arrays.stream(users).forEach( e->
                System.out.println(e.getAge())
        );

        Arrays.sort(users,(a,b)->a.getAge()-b.getAge());
        Arrays.stream(users).forEach( e->
                System.out.println(e.getAge())
        );
    }


}
