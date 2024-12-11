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
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (security[i - 1] >= security[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (left[i] > time && right[i] > time) {
                res.add(i);
            }
        }
        return res;
    }

}
