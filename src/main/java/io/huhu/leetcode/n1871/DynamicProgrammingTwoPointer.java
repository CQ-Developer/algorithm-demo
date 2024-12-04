package io.huhu.leetcode.n1871;

import io.huhu.AC;

@AC
public class DynamicProgrammingTwoPointer implements Code {

    @Override
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] c = s.toCharArray();
        int n = c.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0, l = 0; i < n; i++) {
            if (dp[i]) {
                l = Math.max(l, i + minJump);
                int r = Math.min(i + maxJump, n - 1);
                for (int j = l; j <= r; j++) {
                    dp[j] = c[j] == '0';
                }
                l = r + 1;
            }
        }
        return dp[n - 1];
    }

}
