package io.huhu.leetcode.dynamic.programming.medium.n45;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/description/">跳跃游戏II</a>
 */
class Solution {

    public int jump(int[] nums) {
        // step记录走了几步
        // max记录当前能达到的最远距离
        // end记录上一轮能达到的最远距离
        int step = 0, max = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

}
