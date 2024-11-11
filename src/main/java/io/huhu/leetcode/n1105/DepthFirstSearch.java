package io.huhu.leetcode.n1105;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return f(books, shelfWidth, books.length - 1);
    }

    /**
     * f(i)表示以第i本数结尾的书架的整体最小高度
     */
    private int f(int[][] books, int width, int i) {
        if (i < 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int w = 0, h = 0;
        for (int j = i; j >= 0; j--) {
            w += books[j][0];
            if (w > width) {
                break;
            }
            h = Math.max(h, books[j][1]);
            ans = Math.min(ans, f(books, width, j - 1) + h);
        }
        return ans;
    }

}
