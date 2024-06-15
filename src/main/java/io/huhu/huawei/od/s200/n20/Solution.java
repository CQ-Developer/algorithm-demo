package io.huhu.huawei.od.s200.n20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 会议室占用时间
 */
class Solution {

    public int[][] mergeMeetingTimes(int[][] times) {
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        List<int[]> a = new ArrayList<>();
        a.addLast(times[0]);
        List<int[]> b = new ArrayList<>();
        for (int i = 1; i < times.length; i++) {
            b.addLast(times[i]);
        }
        while (!b.isEmpty()) {
            int[] x = a.getLast();
            int[] y = b.removeFirst();
            if (x[1] >= y[0]) {
                x[1] = y[1];
            } else {
                a.addLast(y);
            }
        }
        int[][] res = new int[a.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = a.get(i);
        }
        return res;
    }

}
