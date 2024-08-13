package io.huhu.leetcode.dynamic.programming.hard.n546;

class MS implements Solution {

    @Override
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] f = new int[n][n][n];
        return ms(boxes, 0, n - 1, 0, f);
    }

    private int ms(int[] boxes, int l, int r, int p, int[][][] f) {
        if (l > r) {
            return 0;
        }
        if (f[l][r][p] != 0) {
            return f[l][r][p];
        }
        int i = l;
        while (i + 1 <= r && boxes[i + 1] == boxes[l]) {
            i++;
        }
        int n = p + i - l + 1;
        f[l][r][p] = n * n + ms(boxes, i + 1, r, 0, f);
        for (int j = i + 2; j <= r; j++) {
            if (boxes[j] == boxes[l] && boxes[j] != boxes[j - 1]) {
                f[l][r][p] = Math.max(f[l][r][p], ms(boxes, i + 1, j - 1, 0, f) + ms(boxes, j, r, n, f));
            }
        }
        return f[l][r][p];
    }

}
