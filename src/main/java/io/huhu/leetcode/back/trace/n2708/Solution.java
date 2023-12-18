package io.huhu.leetcode.back.trace.n2708;

/**
 * <a href="https://leetcode.cn/problems/maximum-strength-of-a-group/description/">一个小组的最大实力值</a>
 * <p>给你一个下标从0开始的整数数组nums, 它表示一个班级中所有学生在一次考试中的成绩.
 * 老师想选出一部分同学组成一个非空小组, 且这个小组的实力值最大, 如果这个小组里的学生下标为
 * i<sub>0</sub>,i<sub>1</sub>,i<sub>2</sub>,...,i<sub>k</sub>, 那么这个小组的实力值定义为
 * nums[i<sub>0</sub>] * nums[i<sub>1</sub>] * nums[i<sub>2</sub>] * ... * nums[i<sub>k</sub>].
 * <p>请你返回老师创建的小组能得到的最大实力值为多少.
 */
class Solution {

    private long res = Long.MIN_VALUE;

    /**
     * 提示:
     * <ul>
     * <li>1 <= nums.length <= 13
     * <li>-9 <= nums[i] <= 9
     * </ul>
     */
    public long maxStrength(int[] nums) {
        dfs(nums, 0, 1);
        return res;
    }

    /**
     * 深度优先遍历 + 回溯算法
     */
    private void dfs(int[] nums, int s, long power) {
        if (s > 0 && s <= nums.length) {
            res = Math.max(res, power);
            if (s == nums.length) {
                return;
            }
        }
        for (int i = s; i < nums.length; i++) {
            dfs(nums, i + 1, power * nums[i]);
        }
    }

}
