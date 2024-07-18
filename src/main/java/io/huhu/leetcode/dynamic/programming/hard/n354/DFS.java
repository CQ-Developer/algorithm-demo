package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.util.Arrays;
import java.util.Comparator;

class DFS implements Solution {

    @Override
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        return 0;
    }

}
