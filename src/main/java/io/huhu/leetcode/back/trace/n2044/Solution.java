package io.huhu.leetcode.back.trace.n2044;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-maximum-bitwise-or-subsets/description/">统计按位或能得到最大值的子集数目</a>
 * <p>给你一个整数数组nums, 请你找出nums子集按位或可能得到的最大值, 并返回按位或能得到最大值的不同非空子集的数目.
 * <p>如果数组a可以由数组b删除一些元素得到, 则认为数组a是数组b的一个子集.
 * 如果选中的元素下标位置不一样, 则认为两个子集不同.
 * <p>对数组a执行按位或, 结果等于a[0] or a[1] or ... or a[a.length - 1]
 */
class Solution {

    private int result;

    /**
     * 提示:
     * <ul>
     * <li>1 <= nums.length <= 10
     * <li>1 <= nums[i] <= 10<sup>5</sup>
     * </ul>
     */
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        dfs(nums, 0, max, 0);
        return result;
    }

    /**
     * <p>深度优先遍历 + 回溯
     * <p>核心思考: 既然已经命中max, 那么只需要加上后续的所有可能即可.
     * <p>注意: 命中max的情况下, 后续或任何数都等于max.
     */
    private void dfs(int[] nums, int i, int max, int path) {
        if (path == max) {
            result += 1 << (nums.length - i);
            return;
        }
        if (i == nums.length) {
            return;
        }
        dfs(nums, i + 1, max, path | nums[i]);
        dfs(nums, i + 1, max, path);
    }

}
