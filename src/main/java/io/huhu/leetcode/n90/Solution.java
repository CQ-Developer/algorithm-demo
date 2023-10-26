package io.huhu.leetcode.n90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>
 * 90.子集II
 * </h1>
 *
 * <p>
 * 给你一个整数数组nums，其中可能包含重复元素，请你返回该数组所有可能的子集(幂集)。
 * <br/>
 * 解集不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 * </p>
 *
 * <p>
 * 1 <= nums.length <= 10
 * <br/>
 * -10 <= nums[i] <= 10
 * </p>
 */
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTrace(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrace(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            if (j == i || nums[j] != nums[j - 1]) {
                list.add(nums[j]);
                backTrace(nums, j + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

}
