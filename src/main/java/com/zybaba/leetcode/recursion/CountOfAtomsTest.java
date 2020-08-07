package com.zybaba.leetcode.recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/5/22 23:28
 * https://leetcode-cn.com/problems/number-of-atoms/
 * 726. 原子的数量
 */
public class CountOfAtomsTest {
    Map<String, Integer> element;
    String k = "";
    String v = "";

    public String countOfAtoms(String formula) {
        String asn = "";
        element = new HashMap<String, Integer>();
        this.count(formula, 1);
        String[] keys = new String[element.keySet().size()];
        element.keySet().toArray(keys);
        Arrays.sort(keys);
        for (String key : keys) {
            asn = asn.length() > 0 ? asn + ", '" + key + "': " + element.get(key) : "'" + key + "': " + element.get(key);
        }
        return "{" + asn + "}";
    }

    private void count(String subFormula, int times) {
        k = k + subFormula.charAt(0);
        int n = 0;
        for (int i = 1; i < subFormula.length(); i++) {
            char c = subFormula.charAt(i);
            if (c >= 'a' && c <= 'z') {
                k = k + c;
            }
            if (c > '1' && c <= '9') {
                v = v + c;
            }
            if (c >= 'A' && c <= 'Z') {
                if (v.equals("")) {
                    n = 1;
                } else {
                    n = Integer.parseInt(v);
                }
                this.add(k, n * times);
                k = c + "";
            }
        }
        //出现 H2O的情况
        if (!k.equals("")) {
            this.add(k, times);
        }

    }

    private void add(String k, int n) {
        if (element.containsKey(k)) {
            element.put(k, element.get(k) + n);
        } else {
            element.put(k, n);
        }
        k = "";
        v = "";
    }

    @Test
    public void testCase01() {
        CountOfAtomsTest solution = new CountOfAtomsTest();
        String formula = "H2O";
        String expected = "{'H': 2, 'O': 1}";
        String actual = solution.countOfAtoms(formula);
        assertEquals(expected, actual);

    }

}
