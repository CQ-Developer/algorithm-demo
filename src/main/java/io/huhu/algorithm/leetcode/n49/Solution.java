package io.huhu.algorithm.leetcode.n49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!used[i]) {
                used[i] = true;
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (used[j]) {
                        continue;
                    }
                    if (strEquals(strs[i], strs[j])) {
                        used[j] = true;
                        list.add(strs[j]);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    // todo 这种比较方法有些问题 比如 duh ill
    private int sum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            sum += c;
        }
        return sum;
    }

    // todo 超时
    private boolean strEquals(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

}
