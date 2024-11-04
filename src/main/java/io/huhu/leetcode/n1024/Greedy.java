package io.huhu.leetcode.n1024;

import java.util.Arrays;

class Greedy implements Code {

    @Override
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int i = 0, r = 0, maxR = 0, n = clips.length, ans = 0;
        while (i < n) {
            if (clips[i][0] > maxR) {
                break;
            }
            while (i < n && clips[i][0] <= r) {
                maxR = Math.max(maxR, clips[i++][1]);
            }
            ans++;
            if (maxR >= time) {
                return ans;
            }
            r = maxR;
        }
        return -1;
    }

}
