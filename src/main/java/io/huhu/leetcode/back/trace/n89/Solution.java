package io.huhu.leetcode.back.trace.n89;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/gray-code/">89.格雷编码</a></h1>
 * n位格雷码序列是一个由2^n个整数组成的序列, 其中:
 *   1. 每个整数都在范围[0, 2^n - 1]内(含0和2^n - 1)
 *   2. 第一个整数是0
 *   3. 一个整数在序列中不超过一次
 *   4. 每个相邻整数的二进制表示恰好一位不同, 且
 *   5. 第一个和最后一个整数的二进制表示恰好一位不同
 * 给你一个整数n, 返回任一有效的n位格雷码序列
 */
class Solution {

    /**
     * 1 <= n <= 16
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        backTrace(new int[]{0, 1}, n, new StringBuilder(), result);
        return result;
    }

    /**
     * 回溯算法
     * 选择条件: 选取的字符长度等于n
     * 树的设计: 左子树先选0再选1, 右子树先选1再选0
     */
    private void backTrace(int[] nums, int n, StringBuilder sb, List<Integer> result) {
        if (sb.length() == n) {
            result.add(Integer.parseInt(sb.toString(), 2));
            return;
        }
        sb.append(nums[0]);
        backTrace(new int[]{0, 1}, n, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(nums[1]);
        backTrace(new int[]{1, 0}, n, sb, result);
        sb.deleteCharAt(sb.length() - 1);
    }

}
