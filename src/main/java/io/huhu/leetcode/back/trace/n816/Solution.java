package io.huhu.leetcode.back.trace.n816;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/ambiguous-coordinates/description/">816.模糊坐标</a>
 * 我们有一些二维坐标, 如"(1, 3)"或"(2, 0.5)", 然后移除所有逗号, 小数点和空格, 得到一个字符串s.
 * 返回所有可能的原始字符串到一个列表中.
 * 原始的坐标表示法不会存在多余的零, 所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标.
 * 此外, 一个小数点前至少存在一个数, 所以也不会出现".1"形式的数字.
 * 最后返回的列表可以是任意顺序的, 而且注意返回的两个数字中间(逗号之后)都有一个空格.
 */
class Solution {

    /**
     * 4 <= s.length <= 12
     * s[0]="(", s[s.length-1]=")", 且字符串s中的其他元素都是数字.
     */
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            String a = s.substring(0, i);
            if (a.length() > 1 && a.startsWith("0") && a.endsWith("0")) {
                continue;
            }
            String b = s.substring(i);
            if (b.length() > 1 && b.startsWith("0") && b.endsWith("0")) {
                continue;
            }
            List<String> part1 = new ArrayList<>();
            addChecked(new StringBuilder(a), part1);
            List<String> part2 = new ArrayList<>();
            addChecked(new StringBuilder(b), part2);
            for (String p1 : part1) {
                for (String p2 : part2) {
                    String t = "(" + p1 + ", " + p2 + ")";
                    result.add(t);
                }
            }
        }
        return result;
    }

    /**
     * 添加已检查过的坐标
     */
    private void addChecked(StringBuilder sb, List<String> path1) {
        if (check(sb)) {
            path1.add(sb.toString());
        }
        for (int j = 1; j < sb.length(); j++) {
            sb.insert(j, '.');
            if (check(sb)) {
                path1.add(sb.toString());
            }
            sb.deleteCharAt(j);
        }
    }

    /**
     * 检查字符串是否合法
     */
    private boolean check(StringBuilder sb) {
        int n = sb.length();
        if (n == 1) {
            return true;
        }
        int i = sb.indexOf(".");
        if (i != 1 && sb.charAt(0) == '0') {
            return false;
        }
        if (i > 0) {
            int j = n - 1 - i;
            if (j > 0 && sb.charAt(n - 1) == '0') {
                return false;
            }
        }
        return true;
    }

}
