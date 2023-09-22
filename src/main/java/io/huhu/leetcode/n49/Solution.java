package io.huhu.leetcode.n49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1>49.字母异位词分组</h1>
 * <p>
 * 给你一个字符串数组，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * <br>
 * 字母异位词是由重新排列原单词的所有字母得到一个新单词。
 * </p>
 * <br>
 *
 * <p>
 * <b>示例1：</b>
 * <br>
 * 输入：strs = ["eat","tea","tan","ate","nat","bat"]
 * <br>
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * </p>
 * <br>
 *
 * <p>
 * <b>示例2：</b>
 * <br>
 * 输入：strs = [""]
 * <br>
 * 输出: [[""]]
 * </p>
 * <br>
 *
 * <p>
 * <b>示例1：</b>
 * <br>
 * 输入：strs = ["a"]
 * <br>
 * 输出: [["a"]]
 * </p>
 * <br>
 *
 * <p>
 * <b>提示：</b>
 * 1 <= strs.length <= 10<sup>4</sup>
 * <br>
 * 0 <= strs[i].length <= 100
 * <br>
 * strs[i]仅包含小写字母
 * </p>
 */
class Solution {

    /**
     * <h2>使用排序进行分组</h2>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * <h2>使用 {@link java.util.stream.Stream 流} 解决问题</h2>
     * <p>这种写法更加优雅，但是性能较差</p>
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = Stream.of(strs).collect(Collectors.groupingBy(
                str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()));
        return new ArrayList<>(map.values());
    }

}
