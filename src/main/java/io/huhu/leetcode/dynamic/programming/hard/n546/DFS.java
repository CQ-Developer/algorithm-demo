package io.huhu.leetcode.dynamic.programming.hard.n546;

class DFS implements Solution {

    @Override
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        return dfs(boxes, 0, n - 1, 0);
    }

    /**
     * 移除从l...r位置上能获得的最大积分
     *
     * @param p l左侧与l位置气球颜色相同存在连续p个气球
     */
    private int dfs(int[] boxes, int l, int r, int p) {
        if (l > r) {
            return 0;
        }
        // 直接合并l左侧连续n个和l位置相同颜色的气球
        int i = l;
        while (i + 1 <= r && boxes[i + 1] == boxes[l]) {
            i++;
        }
        // 移除到i位置的所有盒子
        int n = p + i - l + 1;
        int ans = n * n + dfs(boxes, i + 1, r, 0);
        // i+1位置和l位置颜色不同, 因此从i+2位置开始尝试
        for (int j = i + 2; j <= r; j++) {
            // 只需要找到下一个相同颜色气球的头位置, 因此使用boxes[j] != boxes[j - 1]进行减枝
            if (boxes[j] == boxes[l] && boxes[j] != boxes[j - 1]) {
                // i+1到j-1位置是不同颜色, 直接移除
                ans = Math.max(ans, dfs(boxes, i + 1, j - 1, 0) + dfs(boxes, j, r, n));
            }
        }
        return ans;
    }

}
