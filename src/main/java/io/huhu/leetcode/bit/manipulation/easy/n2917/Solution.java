package io.huhu.leetcode.bit.manipulation.easy.n2917;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-or-of-an-array/description/">找出数组中的K-or值</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 50</li>
     * <li>0 <= nums[i] <= 2<sup>31</sup></li>
     * <li>1 <= k <= nums.length</li>
     * </ul>
     */
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> i) & 1;
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
