package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author tiandongbo
 * @date 2020/06/09 22:40
 */
public class GroupAnagramsTest {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        String key;
        char[] chars;
        for (int i = 0; i < strs.length; i++) {
            chars = strs[i].toCharArray();
            Arrays.sort(chars);
            key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        res.addAll(map.values());
        return res;
    }

    @Test
    public void testCase() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagramsTest solution = new GroupAnagramsTest();
        System.out.println(solution.groupAnagrams(strs));

    }
}
