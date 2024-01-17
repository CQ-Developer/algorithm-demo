package io.huhu.leetcode.dynamic.programming.easy.n119;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/description/">杨辉三角II</a>
 */
class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre;
        List<Integer> res = List.of(1);
        for (int i = 1; i <= rowIndex; i++) {
            pre = res;
            res = new ArrayList<>(i + 1);
            res.add(1);
            for (int j = 1; j < i; j++) {
                res.add(pre.get(j - 1) + pre.get(j));
            }
            res.add(1);
        }
        return res;
    }

}
