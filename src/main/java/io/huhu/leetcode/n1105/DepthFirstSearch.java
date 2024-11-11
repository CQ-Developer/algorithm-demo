package io.huhu.leetcode.n1105;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DepthFirstSearch implements Code {

    @Override
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(books, shelfWidth, dp, n - 1);
    }

    private int f(int[][] books, int width, int[] dp, int i) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        int w = 0, h = 0;
        for (int j = i; j >= 0; j--) {
            w += books[j][0];
            if (w > width) {
                break;
            }
            h = Math.max(h, books[j][1]);
            ans = Math.min(ans, f(books, width, dp, j - 1) + h);
        }
        return dp[i] = ans;
    }

}
