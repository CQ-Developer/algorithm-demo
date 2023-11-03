package io.huhu.leetcode.back.trace.n17;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">17.电话号码的字母组合</a></h1>
 * 给定一个包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回
 * <br/>
 * 给出数字到字母的映射如下(与电话按键相同)，注意1不对应任何字母
 * <br/>
 */
class Solution {

    private final String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backTrace(digits, 0, new StringBuilder(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(String digits, int i, StringBuilder sb, List<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        var letter = letters[digits.charAt(i) - '0'];
        for (int j = 0; j < letter.length(); j++) {
            sb.append(letter.charAt(j));
            backTrace(digits, i + 1, sb, result);
            sb.deleteCharAt(i);
        }
    }

}
