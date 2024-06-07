package io.huhu.leetcode.dynamic.programming.medium.n368;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/largest-divisible-subset/description/">Largest Divisible Subset</a>
 */
class Solution {

    /**
     * <p>give a set of distinct positive integers nums,
     * return the largest subset answer such that every pair
     * {answer[i], answer[j]} of elements in this subset satisfies:</p>
     * <ul>
     * <li>answer[i] % answer[j] == 0</li>
     * or
     * <li>answer[j] % answer[i] == 0</li>
     * </ul>
     * <p>if there are multiple solutions,
     * return any of them.</p>
     * <ul>
     * <li>1 <= nums.length <= 1000</li>
     * <li>1 <= nums[i] <= 2* 10<sup>9</sup></li>
     * <li>All the integers in nums are unique.</li>
     * </ul>
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            for (int j = i + 1, k = i; j < nums.length; j++, k++) {
                if (nums[k] % nums[j] != 0 && nums[j] % nums[k] != 0) {
                    continue;
                }
                list.add(nums[j]);
            }
            if (list.size() > ans.size()) {
                ans = list;
            }
        }
        return ans;
    }

}
