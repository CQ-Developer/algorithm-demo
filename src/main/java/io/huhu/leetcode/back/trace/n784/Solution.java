package io.huhu.leetcode.back.trace.n784;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-case-permutation/description/">784.字母大小写全排列</a>
 * 给定一个字符串s, 通过将字符串s中的每个字母转变大小写, 我们可以获得一个新的字符串.
 * 返回所有可能得到的字符串集合. 以任意顺序返回输出.
 */
class Solution {

    /**
     * 1 <= s.length <= 12
     * s由小写英文字母, 大写英文字母和数字组成
     */
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        dfs(new StringBuilder(s), 0, result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void dfs(StringBuilder sb, int i, List<String> result) {
        result.add(sb.toString());
        for (int j = i; j < sb.length(); j++) {
            char c = sb.charAt(j);
            if (c < 'A' || (c > 'Z' && c < 'a') || c > 'z') {
                continue;
            }
            sb.setCharAt(j, c <= 'Z' ? (char) (c + 32) : (char) (c - 32));
            dfs(sb, j + 1, result);
            sb.setCharAt(j, c);
        }
    }

}
