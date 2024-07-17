package io.huhu.leetcode.classic.two.sum.n1;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/description/">
 * Two Sum
 * </a>
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
