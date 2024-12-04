package io.huhu.leetcode.n1871;

import io.huhu.AC;

@AC
class DynamicProgrammingSlidingWindow implements Code {

    @Override
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] c = s.toCharArray();
        int n = c.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = minJump, cnt = 1; i < n; i++) {
            // 当前坐标是否可达
            if (c[i] == '0' && cnt > 0) {
                dp[i] = true;
            }
            // 滑窗右移左端离开窗口
            if (i >= maxJump && dp[i - maxJump]) {
                cnt--;
            }
            // 滑窗右移右端加入窗口
            if (dp[i - minJump + 1]) {
                cnt++;
            }
        }
        return dp[n - 1];
    }

}
