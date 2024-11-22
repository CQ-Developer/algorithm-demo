package io.huhu.leetcode.n1493;

class DynamicProgramming implements Code {

    /**
     * pre[i]表示以i位置结尾的连续1的最长子数组长度
     * suf[i]表示以i位置开始的连续1的最长子数组长度
     */
    @Override
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        // dp from head
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] == 1 ? pre[i - 1] + 1 : 0;
        }
        // dp from end
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = nums[i] == 1 ? suf[i + 1] + 1 : 0;
        }
        // searching where to delete
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int _pre = i == 0 ? 0 : pre[i - 1];
            int _suf = i == n - 1 ? 0 : suf[i + 1];
            ans = Math.max(ans, _pre + _suf);
        }
        return ans;
    }

}
