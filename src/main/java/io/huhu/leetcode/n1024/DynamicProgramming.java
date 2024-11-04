package io.huhu.leetcode.n1024;

class DynamicProgramming implements Code {

    private static final int MAX = 101;

    @Override
    public int videoStitching(int[][] clips, int time) {
        int[] f = new int[time + 1];
        for (int i = 1; i <= time; i++) {
            f[i] = MAX;
        }
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    f[i] = Math.min(f[i], f[clip[0]] + 1);
                }
            }
        }
        if (f[time] == MAX) {
            return -1;
        }
        return f[time];
    }

}
