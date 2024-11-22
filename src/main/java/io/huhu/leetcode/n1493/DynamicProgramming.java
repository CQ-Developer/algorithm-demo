package io.huhu.leetcode.n1493;

class DynamicProgramming implements Code {

    /**
     * pre[i]表示以i位置结尾的连续1的最长子数组长度
     * oneDeletionPre[i]表示以i位置结尾且可以删除一个0后得到的连续1的最长子数组
     */
    @Override
    public int longestSubarray(int[] nums) {
        int n = nums.length, ans = 0;
        int[] pre = new int[n], oneDeletionPre = new int[n];
        pre[0] = oneDeletionPre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == 1) {
                pre[i] = pre[i - 1] + 1;
                oneDeletionPre[i] = oneDeletionPre[i - 1] + 1;
            } else {
                pre[i] = 0;
                oneDeletionPre[i] = pre[i - 1];
            }
            ans = Math.max(ans, oneDeletionPre[i]);
        }
        if (ans == n) {
            ans--;
        }
        return ans;
    }

}
