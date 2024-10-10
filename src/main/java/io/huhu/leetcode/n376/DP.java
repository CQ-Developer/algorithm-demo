package io.huhu.leetcode.n376;

class DP implements Code {

    @Override
    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

}
