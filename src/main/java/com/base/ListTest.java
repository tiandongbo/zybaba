package com.base;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tiandongbo
 * @date 2020/5/24 17:40
 */
public class ListTest {

    @Test
    public void  testCase01(){
        ArrayList<String> list=new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        //list 转数组
        String[] strings = new String[list.size()];
        list.toArray(strings);
        for (String s: strings){
            System.out.println(s);
        }

        //数组创建list
        String[] s = {"a","c","b"};
        List list1 = Arrays.asList(s);

        //对list元素进行排序
        Collections.sort(list1);
        System.out.println(list1);
    }
}
