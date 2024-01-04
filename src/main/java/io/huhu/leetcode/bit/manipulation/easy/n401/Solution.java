package io.huhu.leetcode.bit.manipulation.easy.n401;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-watch/description/">二进制手表</a>
 */
class Solution {

    /**
     * <p>核心思路: 统计1的位数</p>
     * <img src="https://assets.leetcode.com/uploads/2021/04/08/binarywatch.jpg"/>
     * <p>如图所示, 手表当前显示时间为4:51, 其中51=32+16+2+1</p>
     * <pre>
     * # 51的二进制表示
     * 110011
     *
     * # 相当于将32或16或2或1, 将4个数的所有为1的位合并
     *   100000
     * | 010000
     * | 000010
     * | 000001
     * = 110011
     * </pre>
     * <p>可以看出, 亮一个灯相当于二进制表示中出现一个1,
     * 只要统计时和分所有的二进制表示中1的位数等于turnedOn,
     * 就能求得结果</p>
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return res;
    }

}
