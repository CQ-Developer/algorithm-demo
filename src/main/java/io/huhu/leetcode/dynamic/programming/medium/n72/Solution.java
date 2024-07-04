package io.huhu.leetcode.dynamic.programming.medium.n72;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/description/">
 * Edit Distance
 * </a>
 */
class Solution {

    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();
        int m = s1.length, n = s2.length;
        int[] f = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            f[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            int leftUp = i - 1;
            f[0] = i;
            for (int j = 1; j <= n; j++) {
                int backup = f[j];
                if (s1[i - 1] == s2[j - 1]) {
                    f[j] = leftUp;
                } else {
                    f[j] = 1 + Math.min(leftUp, Math.min(f[j], f[j - 1]));
                }
                leftUp = backup;
            }
        }
        return f[n];
    }

}
