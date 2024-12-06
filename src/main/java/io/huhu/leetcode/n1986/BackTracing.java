package io.huhu.leetcode.n1986;

import io.huhu.AC;

import java.util.Arrays;

@AC
class BackTracing implements Solution {

    private int res = Integer.MAX_VALUE;

    @Override
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        // 从耗时长的任务开始
        Arrays.sort(tasks);
        f(tasks, n - 1, sessionTime, new int[n], 0);
        return res;
    }

    private void f(int[] tasks, int i, int sessionTime, int[] bucket, int cnt) {
        if (cnt >= res) {
            return;
        }
        if (i < 0) {
            res = cnt;
            return;
        }
        // 剪枝: 同样容量的桶之前尝试过, 再次尝试没有意义
        int[] used = new int[sessionTime + 1];
        for (int j = 0; j < bucket.length; j++) {
            if (tasks[i] + bucket[j] <= sessionTime && used[bucket[j]] == 0) {
                used[bucket[j]] = 1;
                boolean newBucket = bucket[j] == 0;
                bucket[j] += tasks[i];
                f(tasks, i - 1, sessionTime, bucket, newBucket ? cnt + 1 : cnt);
                bucket[j] -= tasks[i];
            }
        }
    }

}
