package io.huhu.leetcode.n1024;

class Greedy implements Code {

    @Override
    public int videoStitching(int[][] clips, int time) {
        // furthest coverage to right
        // 记录每个开始时间能够达到的最远结束时间
        int[] furthest = new int[time];
        for (int[] clip : clips) {
            int f = clip[0];
            if (f < time) {
                furthest[f] = Math.max(furthest[f], clip[1]);
            }
        }
        int pre = 0, end = 0, ans = 0;
        for (int i = 0; i < time; i++) {
            end = Math.max(end, furthest[i]);
            if (i == end) {
                return -1;
            }
            if (i == pre) {
                pre = end;
                ans++;
            }
        }
        return ans;
    }

}
