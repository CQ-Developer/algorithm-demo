package io.huhu.leetcode.back.trace.interview.questions.n08.n04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/power-set-lcci/description/">幂集</a>
 * <p>幂集. 编写一种方法, 返回某集合的所有子集. 集合中不包含重复的元素.
 * <p>说明: 解集不能包含重复的子集.
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing(nums, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void backTracing(int[] nums, int j, Deque<Integer> path, List<List<Integer>> res) {
        if (j <= nums.length) {
            res.add(new ArrayList<>(path));
            if (j == nums.length) {
                return;
            }
        }
        for (int i = j; i < nums.length; i++) {
            path.addLast(nums[i]);
            backTracing(nums, i + 1, path, res);
            path.removeLast();
        }
    }

}
