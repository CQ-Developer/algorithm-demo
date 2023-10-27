package io.huhu.leetcode.back.trace.n401;

import java.util.ArrayList;
import java.util.List;

/**
 * 401.二进制手表
 * <br/>
 * 二进制手表顶部有4个LED代表小时(0-11)，底部的6个LED代表分钟(0-59)，每个LED代表一个0或1，最低位左右侧
 * <br/>
 * 例如，下面的二进制手表读取"4:51"
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2021/04/08/binarywatch.jpg"/>
 * <br/>
 * 给你一个整数turnedOn，表示当前亮着的LED的数量，返回二进制手表可以表示的所有可能时间。你可以按任意顺序返回答案
 * <br/>
 * 小时不会以0开头：
 * <br/>
 * 例如，"01:00"是无效的时间，正确的写法应该是"1:00"
 * <br/>
 * 分钟必须由两位数组成，可能会以零开头：
 * <br/>
 * 例如，"10:2"是无效的时间，正确的写法应该是"10:02"
 */
class Solution {

    private final int[] times = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    /**
     * 补充穷举算法，时间复杂度O(1)，空间复杂度O(1)
     * <pre>{@code
     * public List<String> readBinaryWatch(int turnedOn) {
     *     List<String> list = new ArrayList<>();
     *     for (int h = 0; h < 12; h++) {
     *         for (int m = 0; m < 60; m++) {
     *             if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
     *                 list.add(h + ":" + (m > 10 ? m : "0" + m));
     *             }
     *         }
     *     }
     *     return list;
     * }
     * }</pre>
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        traceBack(turnedOn, 0, 0, 0, result);
        return result;
    }

    private void traceBack(int turnedOn, int h, int m, int i, List<String> result) {
        if (turnedOn == 0) {
            result.add(h + ":" + (m > 9 ? m : "0" + m));
        }
        for (int j = i; j < 10 && turnedOn > 0; j++) {
            if (j < 4 && h + times[j] < 12) {
                traceBack(turnedOn - 1, h + times[j], m, j + 1, result);
            }
            if (j >= 4 && m + times[j] < 60) {
                traceBack(turnedOn - 1, h, m + times[j], j + 1, result);
            }
        }
    }

}
