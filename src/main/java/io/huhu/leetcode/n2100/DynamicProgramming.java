package io.huhu.leetcode.n2100;

import io.huhu.AC;

import java.util.ArrayList;
import java.util.List;

@AC
class DynamicProgramming implements Solution {

    @Override
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> res = new ArrayList<>();
        if (n < time * 2 + 1) {
            return res;
        }
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        int[] inc = new int[n], dec = new int[n];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            if (security[i - 1] >= security[i]) {
                inc[i] = inc[i - 1] + 1;
            }
            if (security[j] <= security[j + 1]) {
                dec[j] = dec[j + 1] + 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (inc[i] >= time && dec[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }

}
