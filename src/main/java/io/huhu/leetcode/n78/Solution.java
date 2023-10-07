package io.huhu.leetcode.n78;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>
 * 78.子集
 * </h1>
 *
 * <p>
 * 给你一个整数数组nums，数组中的元素互不相同，返回该数组所有可能的子集(幂集)。
 * <br/>
 * 解集不能包含重复的子集，你可以按任意顺序返回解集。
 * </p>
 *
 * <p>
 * 示例一：
 * <br/>
 * 输入：nums = [1,2,3]
 * <br/>
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * 输入：nums = [0]
 * <br/>
 * 输出：[[], [0]]
 * </p>
 *
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * <br/>
 * -10 <= nums[i] <= 10
 * <br/>
 * nums中的所有元素互不相同
 * </p>
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, 0, i + 1, new ArrayList<>(), result);
        }
        return result;
    }

    private void dfs(int[] nums, int i, int count, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == count) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(nums, j + 1, count, path, result);
            path.remove(path.size() - 1);
        }
    }

}
