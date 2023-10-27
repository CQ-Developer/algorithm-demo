package io.huhu.leetcode.back.trace.n17;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">17.电话号码的字母组合</a>
 * <br/>
 * 给定一个包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回
 * <br/>
 * 给出数字到字母的映射如下(与电话按键相同)，注意1不对应任何字母
 */
class Solution {

    private final Map<Character, List<String>> numbers = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {
        // todo 待完成
        return null;
    }

}
