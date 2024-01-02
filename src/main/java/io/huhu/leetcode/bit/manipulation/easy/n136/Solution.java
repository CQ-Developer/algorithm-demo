package io.huhu.leetcode.bit.manipulation.easy.n136;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/single-number/description/">只出现一次的数字</a>
 */
public class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> bitMap = new HashMap<>(nums.length);
        for (int num : nums) {
            int count = bitMap.getOrDefault(num, 0);
            bitMap.put(num, ++count);
        }
        for (Integer num : bitMap.keySet()) {
            if (bitMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

}
