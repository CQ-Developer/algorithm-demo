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
        return result;
    }

}
