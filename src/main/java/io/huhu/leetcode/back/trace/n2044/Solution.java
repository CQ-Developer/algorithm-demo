package io.huhu.leetcode.back.trace.n2044;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-maximum-bitwise-or-subsets/description/">统计按位或能得到最大值的子集数目</a>
 * <p>给你一个整数数组nums, 请你找出nums子集按位或可能得到的最大值, 并返回按位或能得到最大值的不同非空子集的数目.
 * <p>如果数组a可以由数组b删除一些元素得到, 则认为数组a是数组b的一个子集.
 * 如果选中的元素下标位置不一样, 则认为两个子集不同.
 * <p>对数组a执行按位或, 结果等于a[0] or a[1] or ... or a[a.length - 1]
 */
class Solution {

    /**
     * 提示:
     * <ul>
     * <li>1 <= nums.length <= 10
     * <li>1 <= nums[i] <= 10<sup>5</sup>
     * </ul>
     */
    public int countMaxOrSubsets(int[] nums) {
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums, 0, i, 0, 0, map);
        }
        return map.lastEntry().getValue();
    }

    private void dfs(int[] nums, int i, int len, int cnt, int path, Map<Integer, Integer> result) {
        if (cnt == len) {
            result.compute(path, (k, v) -> v == null ? 1 : v + 1);
            return;
        }
        for (int j = i; j < nums.length && j <= nums.length - len + cnt + 1; j++) {
            dfs(nums, j + 1, len, cnt + 1, path | nums[j], result);
        }
    }

}
