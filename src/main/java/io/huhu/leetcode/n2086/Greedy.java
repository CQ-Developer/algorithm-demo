package io.huhu.leetcode.n2086;

import io.huhu.AC;

@AC
class Greedy implements Solution {

    @Override
    public int minimumBuckets(String hamsters) {
        char[] c = hamsters.toCharArray();
        int n = c.length, p = -2, res = 0;
        for (int i = 0; i < n; i++) {
            // 当前到达仓鼠位置且左边没有放过桶
            if (c[i] == 'H' && p != i - 1) {
                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {
                    // 优先在右侧放置桶
                    p = i + 1;
                    res++;
                } else if (i > 0 && hamsters.charAt(i - 1) == '.') {
                    // 在左侧放置桶
                    res++;
                } else {
                    // 左右都无法放置桶
                    return -1;
                }
            }
        }
        return res;
    }

}
