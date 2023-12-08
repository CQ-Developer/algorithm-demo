package io.huhu.leetcode.back.trace.n1986;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/description/">完成任务的最少工作时间段</a>
 * <p>你被安排了n个任务. 任务需要花费的时间用长度为n的整数数组tasks表示, 第i个任务需要花费tasks[i]小时完成.
 * 一个工作时间段中, 你可以至多连续工作sessionTime个小时, 然后休息一会儿.
 * <p>你需要按如下条件完成给定任务:
 * <ul>
 * <li>如果你在某一个时间段开始一个任务, 你需要在同一个时间段完成它.
 * <li>完成一个任务后, 你可以立马开始一个新的任务.
 * <li>你可以按任意顺序完成任务.
 * </ul>
 * <p>给你tasks和sessionTime, 请你按照上述要求, 返回完成所有任务所需要的最少数目的工作时间段.
 * <p>测试数据保证sessionTime大于等于tasks[i]中的最大值.
 */
class Solution {

    private int result;

    /**
     * <p>提示:
     * <ul>
     * <li>n == tasks.length
     * <li>1 <= n <= 14
     * <li>1 <= tasks[i] <= 10
     * <li>max(tasks[i]) <= sessionTime <= 15
     * </ul>
     */
    public int minSessions(int[] tasks, int sessionTime) {
        result = tasks.length;
        dfs(tasks, 0, sessionTime, new int[tasks.length], 0);
        return result;
    }

    /**
     * 回溯
     */
    private void dfs(int[] tasks, int i, int sessionTime, int[] path, int p) {
        if (p + 1 >= result) {
            return;
        }
        if (i == tasks.length) {
            result = p + 1;
            return;
        }
        for (int j = 0; j < path.length; j++) {
            path[j] += tasks[i];
            if (path[j] <= sessionTime) {
                dfs(tasks, i + 1, sessionTime, path, Math.max(p, j));
            }
            path[j] -= tasks[i];
        }
    }

}
