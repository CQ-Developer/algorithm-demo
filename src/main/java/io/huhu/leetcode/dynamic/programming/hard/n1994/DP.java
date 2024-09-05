package io.huhu.leetcode.dynamic.programming.hard.n1994;

class DP implements Solution {

    private static final int N = 30;
    private static final int M = 1000000007;

    private static final int[] TABLE = {
        0b0000000000, // 0
        0b0000000000, // 1
        0b0000000001, // 2
        0b0000000010, // 3
        0b0000000000, // 4
        0b0000000100, // 5
        0b0000000011, // 6
        0b0000001000, // 7
        0b0000000000, // 8
        0b0000000000, // 9
        0b0000000101, // 10
        0b0000010000, // 11
        0b0000000000, // 12
        0b0000100000, // 13
        0b0000001001, // 14
        0b0000000110, // 15
        0b0000000000, // 16
        0b0001000000, // 17
        0b0000000000, // 18
        0b0010000000, // 19
        0b0000000000, // 20
        0b0000001010, // 21
        0b0000010001, // 22
        0b0100000000, // 23
        0b0000000000, // 24
        0b0000000000, // 25
        0b0000100001, // 26
        0b0000000000, // 27
        0b0000000000, // 28
        0b1000000000, // 29
        0b0000000111, // 30
    };

    @Override
    public int numberOfGoodSubsets(int[] nums) {
        int[] count = new int[N + 1];
        for (int num : nums) {
            count[num]++;
        }
        int[] dp = new int[1 << 10];
        dp[0] = 1;
        for (int i = 0; i < count[1]; i++) {
            dp[0] = (dp[0] << 1) % M;
        }
        for (int i = 2; i <= N; i++) {
            if (count[i] != 0 && TABLE[i] != 0) {
                for (int j = dp.length - 1; j >= 0; j--) {
                    if ((TABLE[i] & j) == TABLE[i] && (j ^ TABLE[i]) >= 0) {
                        dp[j] = (int) (((long) dp[j ^ TABLE[i]] * count[i] + dp[j]) % M);
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 1; j < (1 << 10); j++) {
            ans = (ans + dp[j]) % M;
        }
        return ans;
    }

}
