package io.huhu.leetcode.n907;

/**
 * TLE
 */
class BruteForceSearch implements Code {

    private static final int M = 1000000007;

    @Override
    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % M;
            }
        }
        return ans;
    }

}
