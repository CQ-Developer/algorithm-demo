package io.huhu.leetcode.n152;

class DP implements Code {

    @Override
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 1, max = 1;
        for (int num : nums) {
            if (num < 0) {
                max ^= min;
                min ^= max;
                max ^= min;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
