package io.huhu.leetcode.n2311;

import io.huhu.AC;

@AC
class Greedy implements Solution {

    @Override
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        // amount of zeros
        int zero = 0;
        for (int i = 0; i < n; i++) {
            zero += 1 ^ (s.charAt(i) - '0');
        }
        // count one from right to left
        int one = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                // int out of bounds
                if (n - i > 32) {
                    break;
                }
                if (Long.parseLong(s, i, n, 2) > k) {
                    break;
                }
                one++;
            }
        }
        return zero + one;
    }

}
