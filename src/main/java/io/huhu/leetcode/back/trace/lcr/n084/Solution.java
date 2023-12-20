package io.huhu.leetcode.back.trace.lcr.n084;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/7p8L0Z/description/">全排列II</a>
 * <p>给定一个可包含重复数字的整数集合nums, 按任意顺序返回所有不重复的全排列.
 * <p>提示:
 * <li>1 <= nums.length <= 8
 * <li>-10 <= nums[i] <= 10
 */
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTracing(nums, new boolean[nums.length], new ArrayDeque<>(), res);
        return res;
    }

    private void backTracing(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backTracing(nums, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }

}
