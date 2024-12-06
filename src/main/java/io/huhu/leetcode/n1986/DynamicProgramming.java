package io.huhu.leetcode.n1986;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length, m = 1 << n;
        // 统计所有情况的子集的耗时(在二进制状态下观察)
        int[] times = new int[m];
        for (int i = 0; i < n; i++) {
            int k = 1 << i;
            for (int j = 0; j < k; j++) {
                times[j | k] = times[j] + tasks[i];
            }
        }
        // 动态规划
        // 最差情况每个任务都使用一个时段
        // 显而易见的没有任务时消耗的时间段是0
        int[] f = new int[m];
        Arrays.fill(f, n);
        f[0] = 0;
        // 枚举每一个状态
        for (int s = 1; s < m; s++) {
            // 枚举每一个子集
            // (s - 1) & s: 将二进制的最后一位1消除
            for (int _s = s; _s > 0; _s = (_s - 1) & s) {
                // 如果子集消耗的时间小于1个时段, 那么当前状态可以由子集加1个时段转移过来
                if (times[_s] <= sessionTime) {
                    f[s] = Math.min(f[s], f[s ^ _s] + 1);
                }
            }
        }
        return f[m - 1];
    }

}
