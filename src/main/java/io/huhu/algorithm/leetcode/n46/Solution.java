package io.huhu.algorithm.leetcode.n46;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>
 * 46.全排列
 * </h1>
 *
 * <p>
 * 给定一个不含重复数组的数组nums，返回其所有可能的全排列。
 * 你可以按任意顺序返回答案。
 * </p>
 * <br>
 *
 * <p>
 * <strong>示例1：</strong>
 * <br>
 * 输入：nums = [1,2,3]
 * <br>
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </p>
 * <br>
 *
 * <p>
 * <strong>示例2：</strong>
 * <br>
 * 输入：nums = [0,1]
 * <br>
 * 输出：[[0,1],[1,0]]
 * </p>
 * <br>
 *
 * <p>
 * <strong>示例3：</strong>
 * <br>
 * 输入：nums = [1]
 * <br>
 * 输出：[[1]]
 * </p>
 * <br>
 *
 * <p>
 * <b>提示：</b>
 * <br>
 * 1 <= nums.length <= 6
 * <br>
 * -10 <= nums[i] <= 10
 * <br>
 * nums中的所有整数互不相同
 * </p>
 */
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                dfs(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

}
