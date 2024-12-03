package io.huhu.leetcode.n1824;

import io.huhu.AC;

@AC
class Greedy implements Code {

    @Override
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int i = 0, j = 1, ans = 0;
        while (i < n - 1) {
            if (obstacles[i + 1] != j + 1) {
                i++;
            } else {
                // 跳到a跑道能继续前进达到的最远距离
                int x = i, a = (j + 1) % 3;
                while (x < n && obstacles[x] != a + 1) {
                    x++;
                }
                // 跳到b跑道继续前进能达到的最远距离
                int y = i, b = (j + 2) % 3;
                while (y < n && obstacles[y] != b + 1) {
                    y++;
                }
                j = x > y ? a : b;
                i = Math.max(x, y) - 1;
                ans++;
            }
        }
        return ans;
    }

}
