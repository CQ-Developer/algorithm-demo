package io.huhu.leetcode.n72;

class DP1 implements Code {

    @Override
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int m = w1.length, n = w2.length;
        int[] pre = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            pre[j] = j;
        }
        int[] cur = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    cur[j] = pre[j - 1];
                } else {
                    cur[j] = Math.min(pre[j - 1], Math.min(pre[j], cur[j - 1])) + 1;
                }
            }
            for (int j = 0; j <= n; j++) {
                pre[j] = cur[j];
            }
        }
        return pre[n];
    }

}
