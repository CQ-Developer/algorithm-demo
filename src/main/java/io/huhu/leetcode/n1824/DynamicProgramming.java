package io.huhu.leetcode.n1824;

class DynamicProgramming implements Code {

    private static final int INF = 0x3f3f3f3f;

    @Override
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int f0 = 1, f1 = 0, f2 = 1;
        for (int i = 1; i < n; i++) {
            if (obstacles[i] == 1) {
                f0 = INF;
            }
            if (obstacles[i] == 2) {
                f1 = INF;
            }
            if (obstacles[i] == 3) {
                f2 = INF;
            }
            if (obstacles[i] != 1) {
                f0 = Math.min(f0, Math.min(f1, f2) + 1);
            }
            if (obstacles[i] != 2) {
                f1 = Math.min(f1, Math.min(f0, f2) + 1);
            }
            if (obstacles[i] != 3) {
                f2 = Math.min(f2, Math.min(f0, f1) + 1);
            }
        }
        return Math.min(f0, Math.min(f1, f2));
    }

}
