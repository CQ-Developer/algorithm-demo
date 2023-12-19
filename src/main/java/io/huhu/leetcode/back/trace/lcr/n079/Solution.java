package io.huhu.leetcode.back.trace.lcr.n079;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/TVdhkn/description/">子集</a>
 * <p>给定一个整数数组nums, 数组中的元素互不相同. 返回改数组所有可能的子集 (幂集).
 * <p>解集不能包含重复的子集. 你可以按任意顺序返回解集.
 * <p>提示:
 * <ul>
 * <li>1 <= nums.length <= 10
 * <li>-10 <= nums[i] <= 10
 * <li>nums中所有元素互不相同
 * </ul>
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing(nums, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void backTracing(int[] nums, int i, Deque<Integer> path, List<List<Integer>> res) {
        if (i <= nums.length) {
            res.add(new ArrayList<>(path));
        }
        if (i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            path.addLast(nums[j]);
            backTracing(nums, j + 1, path, res);
            path.removeLast();
        }
    }

}
