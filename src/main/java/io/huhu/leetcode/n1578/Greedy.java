package io.huhu.leetcode.n1578;

import io.huhu.AC;

@AC
class Greedy implements Code {

    /**
     * 找出连续相同的颜色的气球且只留下移除代价最高的一个
     */
    @Override
    public int minCost(String colors, int[] neededTime) {
        char[] cs = colors.toCharArray();
        int i = 0, n = cs.length, ans = 0;
        while (i < n) {
            char c = cs[i];
            int sum = 0, max = 0;
            while (i < n && cs[i] == c) {
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
                i++;
            }
            ans += sum - max;
        }
        return ans;
    }

}
