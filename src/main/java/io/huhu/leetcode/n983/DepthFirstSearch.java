package io.huhu.leetcode.n983;

class DepthFirstSearch implements Code {

    @Override
    public int mincostTickets(int[] days, int[] costs) {
        return f(days, costs, new int[]{1, 7, 30}, new int[days.length], 0);
    }

    /**
     * 第i天出游的最小花费
     */
    private int f(int[] days, int[] costs, int[] dur, int[] cache, int i) {
        if (i == days.length) {
            return 0;
        }
        if (cache[i] != 0) {
            return cache[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < costs.length; j++) {
            // 买这张票能玩到第几天
            int _i = i;
            while (_i < days.length && days[i] + dur[j] > days[_i]) {
                _i++;
            }
            ans = Math.min(ans, costs[j] + f(days, costs, dur, cache, _i));
        }
        return cache[i] = ans;
    }

}
