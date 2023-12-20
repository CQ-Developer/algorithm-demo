package io.huhu.leetcode.back.trace.lcr.n083;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/VvJkup/description/">全排列</a>
 * <p>给定一个不含重复数字的整数数组nums, 返回其所有可能的全排列. 可以按任意顺序返回答案.
 * <p>提示:
 * <li>1 <= nums.length <= 6
 * <li>-10 <= nums[i] <= 10
 * <li>nums中的所有整数互不相同
 */
class Solution {

    public List<List<Integer>> permute(int[] nums) {
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
            used[i] = true;
            path.addLast(nums[i]);
            backTracing(nums, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }

}
