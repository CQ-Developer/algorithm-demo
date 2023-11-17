package io.huhu.leetcode.back.n306;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/additive-number/">306.累加和</a>
 * 累加数是一个字符串, 组成它的数字可以形成累加序列.
 * 一个有效的累加序列必须至少包含3个数字. 除了最开始的两个数字以外, 序列中的每个后续数字必须是它之前两个数字之和.
 * 给你一个只包含数字0~9的字符串, 编写一个算法来判断给定输入是否是累加数. 如果是, 返回true; 否则, 返回false.
 * 说明: 累加序列里的数字, 除数字0之外, 不会以0开头, 所以不会出现1,2,03或者1,02,3的情况.
 */
class Solution {

    /**
     * 1 <= num.length <= 35
     * num仅由数字0~9组成
     */
    public boolean isAdditiveNumber(String num) {
        boolean[] result = {false};
        deepFirstSearch(num, 0, new ArrayList<>(), result);
        return result[0];
    }

    /**
     * 深度优先搜索: 回溯算法
     */
    private void deepFirstSearch(String sequence, int i, List<String> path, boolean[] result) {
        if (path.size() > 2) {
            if (!path.get(path.size() - 1).equals(sum(path.get(path.size() - 2), path.get(path.size() - 3)))) {
                return;
            } else if (i == sequence.length()) {
                result[0] = true;
            }
        }
        // 剪枝1
        // 已经证明了是字符串是一个累加数
        // 程序不用再进行下去了
        for (int j = i; j < sequence.length() && !result[0]; j++) {
            boolean is0 = sequence.charAt(i) == '0';
            var num = is0 ? sequence.substring(i, i + 1) : sequence.substring(i, j + 1);
            if (path.size() >= 2) {
                var a = path.get(path.size() - 1);
                var b = path.get(path.size() - 2);
                var sum = sum(a, b);
                // 剪枝2
                // 如果当前数字是0, 那么前两个数必须都是0
                if (is0 && !"0".equals(a) || is0 && !"0".equals(b)) {
                    return;
                }
                // 剪枝3
                // 如果当前数字小于前两个数字中的一个, 那么前两个数字的和不可能等于当前数字
                if (num.length() < a.length() || num.length() == a.length() && num.compareTo(sum) < 0) {
                    continue;
                }
                // 剪枝3
                // 如果当前数字小于前两个数字中的一个, 那么前两个数字的和不可能等于当前数字
                if (num.length() < b.length() || num.length() == b.length() && num.compareTo(sum) < 0) {
                    continue;
                }
                // 剪枝4
                // 如果当前数字大于前两个数字之和, 那么后续截取到的数字只会更大
                if (num.length() > sum.length() || num.length() == sum.length() && num.compareTo(sum) > 0) {
                    return;
                }
            }
            // 递归 & 回溯
            path.add(num);
            deepFirstSearch(sequence, is0 ? i + 1 : j + 1, path, result);
            path.remove(path.size() - 1);
            // 剪枝5
            // 如果是0, 那么只能用0, 后续不用再继续做了
            if (is0) {
                return;
            }
        }
    }

    /**
     * 计算两个数字字符串的和
     */
    private String sum(String a, String b) {
        int n = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        var builder = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int x = a.charAt(i--) - '0';
            int y = b.charAt(j--) - '0';
            int sum = x + y + n;
            if (sum >= 10) {
                n = 1;
                sum -= 10;
            } else {
                n = 0;
            }
            builder.append(sum);
        }
        while (i >= 0) {
            int c = a.charAt(i--) - '0';
            int sum = c + n;
            if (sum >= 10) {
                n = 1;
                sum -= 10;
            } else {
                n = 0;
            }
            builder.append(sum);
        }
        while (j >= 0) {
            int c = b.charAt(j--) - '0';
            int sum = c + n;
            if (sum >= 10) {
                n = 1;
                sum -= 10;
            } else {
                n = 0;
            }
            builder.append(sum);
        }
        if (n == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }

}
