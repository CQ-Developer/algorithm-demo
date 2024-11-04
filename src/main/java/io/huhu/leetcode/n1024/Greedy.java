package io.huhu.leetcode.n1024;

class Greedy implements Code {

    @Override
    public int videoStitching(int[][] clips, int time) {
        // furthest coverage to right
        int[] f = new int[time];
        for (int[] clip : clips) {
            if (clip[0] < time) {
                f[clip[0]] = Math.max(f[clip[0]], clip[1]);
            }
        }
        int pre = 0, last = 0, ans = 0;
        for (int i = 0; i < time; i++) {
            last = Math.max(last, f[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                pre = last;
                ans++;
            }
        }
        return ans;
    }

}
