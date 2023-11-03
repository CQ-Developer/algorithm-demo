package io.huhu.leetcode.back.trace.n17;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">17.电话号码的字母组合</a>
 * <br/>
 * 给定一个包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回
 * <br/>
 * 给出数字到字母的映射如下(与电话按键相同)，注意1不对应任何字母
 * <br/>
 * 递归算法：
 * <pre>{@code
 * public List<String> letterCombinations(String digits) {
 *     List<String> result = new ArrayList<>();
 *     if (digits.isEmpty()) {
 *         return result;
 *     }
 *     letterCombinations(digits, 0, "", result);
 *     System.out.println(result);
 *     return result;
 * }
 *
 * private void letterCombinations(
 *         String digits, int i, String s, List<String> result) {
 *     if (i == digits.length()) {
 *         result.add(s);
 *         return;
 *     }
 *     char c = digits.charAt(i);
 *     var letters = letters[c - '0'];
 *     for (int j = 0; j < letters.length(); j++) {
 *         letterCombinations(digits, i + 1, s + letters.charAt(j), result);
 *     }
 * }
 * }</pre>
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
