package io.huhu.leetcode.back.trace.n282;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/expression-add-operators/description/">给表达式添加运算符</a>
 * <p>给定一个仅包含数字0-9的字符串num和一个目标整数target,
 * 在num的数字之间添加二元运算符+、-或*, 返回所有能够得到target的表达式
 * <p>注意, 返回表达式中的操作数不应该包含前导零.
 * <p>提示:
 * <ul>
 * <li>1 <= nums.length <= 10
 * <li>num 仅含数字
 * <li>-2<sup>31</sup> <= target <= 2<sup>31</sup>
 * </ul>
 */
class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backTracing(num.toCharArray(), 0, 0, 0, new StringBuilder(), target, res);
        return res;
    }

    private void backTracing(char[] nums, int j, long cur, long pre, StringBuilder expr, int target, List<String> res) {
        if (j == nums.length) {
            if (cur == target) {
                res.add(expr.toString());
            }
            return;
        }
        int marker = expr.length();
        if (j > 0) {
            expr.append(0);
        }
        long num = 0;
        for (int i = j; i < nums.length && (i == j || nums[j] != '0'); i++) {
            num = 10 * num + (nums[i] - '0');
            expr.append(nums[i]);
            if (j == 0) {
                backTracing(nums, i + 1, num, num, expr, target, res);
            } else {
                // 计算加法
                expr.setCharAt(marker, '+');
                backTracing(nums, i + 1, cur + num, num, expr, target, res);
                // 计算减法, a - b 相当于 a + -b
                expr.setCharAt(marker, '-');
                backTracing(nums, i + 1, cur - num, -num, expr, target, res);
                // 乘法, 这个算法很秀 cur - pre + pre * num
                expr.setCharAt(marker, '*');
                backTracing(nums, i + 1, cur - pre + pre * num, num * pre, expr, target, res);
            }
        }
        expr.setLength(marker);
    }

}
