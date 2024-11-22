package io.huhu.leetcode.n1493;

class DynamicProgramming implements Code {

    /**
     * pre[i]表示以i位置结尾的连续1的最长子数组长度
     * oneDeletionPre[i]表示以i位置结尾且可以删除一个0后得到的连续1的最长子数组
     */
    @Override
    public int longestSubarray(int[] nums) {
        int n = nums.length, ans = 0;
        int a = nums[0], b = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == 1) {
                a++;
                b++;
            } else {
                b = a;
                a = 0;
            }
            ans = Math.max(ans, b);
        }
        if (ans == n) {
            ans--;
        }
        return ans;
    }

}
