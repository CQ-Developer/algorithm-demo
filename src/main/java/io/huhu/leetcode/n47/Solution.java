package io.huhu.leetcode.n47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>47.全排列II</h1>
 * <p>给定一个可包含重复数字的序列nums，按任意顺序返回所有不重复的全排列。</p>
 * <br>
 * <p>
 * <strong>示例1：</strong>
 * <br>
 * 输入: nums = [1,1,2]
 * <br>
 * 输出：[[1,1,2],[1,2,1],[2,1,1]]
 * </p>
 * <br>
 * <p>
 * <strong>示例2：</strong>
 * <br>
 * 输入：nums = [1,2,3]
 * <br>
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </p>
 * <br>
 * <p>
 * <b>提示：</b>
 * <br>
 * 1 <= nums.length <= 8
 * <br>
 * -10 <= nums[i] <= 10
 * </p>
 */
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] flags, List<Integer> list, List<List<Integer>> result) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !flags[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            flags[i] = true;
            dfs(nums, flags, list, result);
            list.remove(list.size() - 1);
            flags[i] = false;
        }
    }

}
