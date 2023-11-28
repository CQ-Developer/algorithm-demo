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

    private final char[] items = {',', '.'};

    /**
     * 4 <= s.length <= 12
     * s[0]="(", s[s.length-1]=")", 且字符串s中的其他元素都是数字.
     */
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        dfs(new StringBuilder(s), 0, result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void dfs(StringBuilder sb, int j, List<String> result) {
        if (j > 0) {
            int i = sb.indexOf(",");
            String part1 = sb.substring(1, i);
            String part2 = sb.substring(i + 1, sb.length() - 1);
            // 两边都是整数
            if (j == 1) {
                if (checkInt(part1) && checkInt(part2)) {
                    setResult(sb, result, i);
                }
            }
            // 一边是整数, 另一边是浮点数
            if (j == 2) {
                // 前边是浮点数, 后边是整数
                if (sb.indexOf(".") < i) {
                    if (checkFloat(part1) && checkInt(part2)) {
                        setResult(sb, result, i);
                    }
                    // 后边只有一位不可能变为浮点数
                    if (part2.length() == 1) {
                        return;
                    }
                }
                // 前边是整数, 后边是浮点数
                else {
                    if (checkInt(part1) && checkFloat(part2)) {
                        setResult(sb, result, i);
                    }
                    return;
                }
            }
            // 两边都是浮点数
            if (j == 3) {
                if (checkFloat(part1) && checkFloat(part2)) {
                    setResult(sb, result, i);
                }
                return;
            }
        }
        for (int i = 2; i <= sb.length() - 2; i++) {
            sb.insert(i, items[j < 2 ? j : 1]);
            dfs(sb, j + 1, result);
            sb.deleteCharAt(i);
        }
    }

    /**
     * 添加结果
     */
    private void setResult(StringBuilder sb, List<String> result, int i) {
        sb.insert(i + 1, ' ');
        result.add(sb.toString());
        sb.deleteCharAt(i + 1);
    }

    /**
     * 判断整数是否合法
     */
    private boolean checkInt(String i) {
        return i.length() == 1 || !i.startsWith("0");
    }

    /**
     * 判断浮点数是否合法
     */
    private boolean checkFloat(String f) {
        int i = f.indexOf(".");
        if (i < 0) {
            return false;
        }
        if (f.length() == 2) {
            return false;
        }
        if (f.startsWith(".") || f.endsWith(".") || f.endsWith("0")) {
            return false;
        }
        String s = f.substring(0, i);
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        return true;
    }

}
