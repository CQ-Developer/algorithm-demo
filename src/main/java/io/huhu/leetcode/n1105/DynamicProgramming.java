package io.huhu.leetcode.n1105;

class DynamicProgramming implements Code {

    @Override
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int ans = Integer.MAX_VALUE;
            int w = 0, h = 0;
            for (int j = i; j >= 0; j--) {
                w += books[j][0];
                if (w > shelfWidth) {
                    break;
                }
                h = Math.max(h, books[j][1]);
                ans = Math.min(ans, f[j] + h);
            }
            f[i + 1] = ans;
        }
        return f[n];
    }

}
