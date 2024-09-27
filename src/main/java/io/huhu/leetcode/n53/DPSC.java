package io.huhu.leetcode.n53;

class DPSC implements Code {

    @Override
    public int maxSubArray(int[] nums) {
        int ans = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

}
