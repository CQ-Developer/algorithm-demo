package io.huhu.leetcode.n1395;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int numTeams(int[] rating) {
        int n = rating.length;
        // less[i]表示i左侧比他小的数的个数
        // more[i]表示i左侧比他大的数的个数
        // rating要不上上升序列, 要不是下降序列
        int[] less = new int[n], more = new int[n];
        if (rating[0] < rating[1]) {
            less[1] = 1;
        } else {
            more[1] = 1;
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] < rating[i]) {
                    less[i]++;
                    ans += less[j];
                } else {
                    more[i]++;
                    ans += more[j];
                }
            }
        }
        return ans;
    }

}
