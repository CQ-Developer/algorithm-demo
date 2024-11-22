package io.huhu.leetcode.n1493;

class DynamicProgramming implements Code {

    /**
     * a表示以i位置结尾的连续1的最长子数组长度
     * b表示以i位置结尾且可以删除一个0后得到的连续1的最长子数组
     */
    @Override
    public int longestSubarray(int[] nums) {
        int ans = 0, a = 0, b = 0;
        for (int num : nums) {
            if (num == 1) {
                a++;
                b++;
            } else {
                b = a;
                a = 0;
            }
            ans = Math.max(ans, b);
        }
        if (ans == nums.length) {
            ans--;
        }
        return ans;
    }

}
