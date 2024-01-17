package io.huhu.leetcode.dynamic.programming.easy.n118;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle/description/">杨辉三角</a>
 */
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        if (numRows < 2) {
            return res;
        }
        res.add(List.of(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> pre = res.get(i - 1);
            List<Integer> cur = new ArrayList<>(i);
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }

}
