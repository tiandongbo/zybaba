package com.zybaba.leetcode.backtrack;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/06/01 23:02
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 */
public class LetterCombinationsTest {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();


    public List<String> letterCombinations(String digits) {

        if (digits==null||digits.length()==0){
            return output;
        }
         backtrack("",digits);
        return  output;
    }

    public void backtrack(String str, String nextDigits) {
        if (nextDigits.length()==0){
            output.add(str);
            return;
        }
         String digit = nextDigits.substring(0, 1);
          String letters = phone.get(digit);
          for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(str + letter, nextDigits.substring(1));
            }
        }

    @Test
    public void testCase01() {
        LetterCombinationsTest solution = new LetterCombinationsTest();
        String digits="23";
        List<String>  expected = Arrays.asList(new String[] {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"});
        List<String>  actual = solution.letterCombinations(digits);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
