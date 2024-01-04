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

    private final int[] hs = {1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    private final int[] ms = {0, 0, 0, 0, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        traceBack(turnedOn, 0, 0, 0, result);
        return result;
    }

    private void traceBack(int turnedOn, int h, int m, int i, List<String> result) {
        if (h > 11 || m > 59) {
            return;
        }
        if (turnedOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(h).append(':');
            if (m < 10) {
                sb.append('0');
            }
            sb.append(m);
            result.add(sb.toString());
            return;
        }
        for (int j = i; j < 10; j++) {
            traceBack(turnedOn - 1, h + hs[j], m + ms[j], j + 1, result);
        }
    }

}
