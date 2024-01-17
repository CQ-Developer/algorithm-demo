package io.huhu.leetcode.dynamic.programming.easy.n119;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/description/">杨辉三角II</a>
 */
class Solution {

    public List<Integer> getRow(int rowIndex) {
        Integer[] res = {1};
        for (int i = 1; i <= rowIndex; i++) {
            Integer[] cur = new Integer[i + 1];
            cur[0] = cur[i] = 1;
            for (int j = 1; j < i; j++) {
                cur[j] = res[j - 1] + res[j];
            }
            res = cur;
        }
        return Arrays.asList(res);
    }

}
